package lab.mohit.practiceProblem.libraryManagement;

import java.util.List;

public class Book {
    String id;
    String name;
    String title;
    List<String> authors;
    String genre;

    public Book(String id, String name, String title, List<String> authors, String genre) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.authors = authors;
        this.genre = genre;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public String getGenre() {
        return genre;
    }
}
