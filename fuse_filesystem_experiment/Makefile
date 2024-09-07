CC = gcc
CFLAGS = $(shell pkg-config fuse --cflags)
LDFLAGS = $(shell pkg-config fuse --libs)

all: myfs

myfs: basicFuseFileSystem.o
	$(CC) -o mybasicfilesystem basicFuseFileSystem.o $(LDFLAGS)

basicFuseFileSystem.o: basicFuseFileSystem.c
	$(CC) -c basicFuseFileSystem.c $(CFLAGS)

clean:
	$(RM) mybasicfilesystem basicFuseFileSystem.o

.PHONY: clean
