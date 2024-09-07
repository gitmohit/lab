#define FUSE_USE_VERSION 31

#include <fuse.h>
#include <stdio.h>
#include <string.h>
#include <errno.h>
#include <fcntl.h>
#include <stdlib.h>

typedef struct my_file {
  char *name;
  char *content;
  size_t size;
  int is_dir;
  struct my_file **children;
  int num_children;
  time_t atime;
  time_t mtime;
} my_file;

my_file *root; // root directory of the filesystem

my_file *create_file(const char *name, int is_dir) {
  my_file *new_file = malloc(sizeof(struct my_file));
  new_file->name = strdup(name);
  new_file->content = NULL;
  new_file->size = 0;
  new_file->is_dir = is_dir;
  new_file->children = NULL;
  new_file->num_children = 0;
  return new_file;
}


my_file *find_file(const char *path, my_file *current) {
    if (strcmp(path, "/") == 0) {
      return current;
    }

    char *path_copy = strdup(path);
    char *token = strtok(path_copy, "/");

    while (token != NULL) {
        int found = 0;
        for (int i = 0; i < current->num_children; i++) {
            if (strcmp(current->children[i]->name, token) == 0) {
                current = current->children[i];
                found = 1;
                break;
            }
        }
        if (!found) {
            free(path_copy);
            return NULL;
        }
        token = strtok(NULL, "/");
    }
    free(path_copy);
    return current;
}


// Get file attributes (called when `ls` is used)
static int myfs_getattr(const char *path, struct stat *stbuf) {
    my_file *file = find_file(path, root);
    if (!file) return -ENOENT;

    memset(stbuf, 0, sizeof(struct stat));
    if (file->is_dir) {
        stbuf->st_mode = S_IFDIR | 0755;
        stbuf->st_nlink = 2;
    } else {
        stbuf->st_mode = S_IFREG | 0644;
        stbuf->st_nlink = 1;
        stbuf->st_size = file->size;
    }
    return 0;
}

// Read directory (called when `ls` is used)
static int myfs_readdir(const char *path, void *buf, fuse_fill_dir_t filler, off_t offset, struct fuse_file_info *fi) {
    my_file *dir = find_file(path, root);
    if (!dir || !dir->is_dir) return -ENOENT;

    filler(buf, ".", NULL, 0);
    filler(buf, "..", NULL, 0);

    for (int i = 0; i < dir->num_children; i++) {
        filler(buf, dir->children[i]->name, NULL, 0);
    }
    return 0;
}


// Open a file
static int myfs_open(const char *path, struct fuse_file_info *fi) {
    struct my_file *file = find_file(path, root);
    if (!file || file->is_dir) return -ENOENT;
    return 0;
}

// Read file content
static int myfs_read(const char *path, char *buf, size_t size, off_t offset, struct fuse_file_info *fi) {
    my_file *file = find_file(path, root);
    if (!file) return -ENOENT;

    if (offset < file->size) {
        if (offset + size > file->size)
            size = file->size - offset;
        memcpy(buf, file->content + offset, size);
    } else
        size = 0;
    return size;
}

// Write file content
static int myfs_write(const char *path, const char *buf, size_t size, off_t offset, struct fuse_file_info *fi) {
    my_file *file = find_file(path, root);
    if (!file) return -ENOENT;

    if (file->content == NULL) {
        file->content = malloc(size);
    } else {
        file->content = realloc(file->content, offset + size);
    }

    memcpy(file->content + offset, buf, size);
    file->size = offset + size;
    return size;
}

// Create a file or directory
static int myfs_mknod(const char *path, mode_t mode, dev_t rdev) {
    my_file *parent = root;
    char *dirpath = strdup(path), *filename;
    filename = strrchr(dirpath, '/');
    *filename = '\0'; // Split path from filename
    filename++;

    my_file *parent_dir = find_file(dirpath, parent);
    if (!parent_dir || !parent_dir->is_dir) {
        free(dirpath);
        return -ENOENT;
    }

    my_file *new_file = create_file(filename, S_ISDIR(mode));
    parent_dir->children = realloc(parent_dir->children, (parent_dir->num_children + 1) * sizeof(struct my_file *));
    parent_dir->children[parent_dir->num_children++] = new_file;

    free(dirpath);
    return 0;
}

// Create a directory
static int myfs_mkdir(const char *path, mode_t mode) {
    return myfs_mknod(path, S_IFDIR | 0755, 0);
}

static int myfs_utimens(const char *path, const struct timespec tv[2]) {
    struct my_file *file = find_file(path,root);
    if (file == NULL)
        return -ENOENT;  // File doesn't exist

    // Update the access and modification times
    file->atime = tv[0].tv_sec;
    file->mtime = tv[1].tv_sec;

    return 0;
}


// Filesystem operation table
static struct fuse_operations myfs_oper = {
    .getattr = myfs_getattr,
    .readdir = myfs_readdir,
    .open = myfs_open,
    .read = myfs_read,
    .write = myfs_write,
    .mknod = myfs_mknod,
    .mkdir = myfs_mkdir,
    .utimens = myfs_utimens
};

int main(int argc, char *argv[]) {
    // Initialize the root directory
    root = create_file("/", 1);

    // Start FUSE filesystem
    return fuse_main(argc, argv, &myfs_oper, NULL);
}
