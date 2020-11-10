package java112.project3.TeamMVC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book {
    private List<Book> books;
    private String title;
    private String[] authors;
    private String description;
    private String publisher;
    private String publishedDate;
    private String imageThumbnail;
    private int totalItems;

    public Book() {
        books = new ArrayList<>();
    }//asdsdddd

 public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public Book(String title, String authors, String description, String publisher,
                String publishedDate, String imageThumbnail, int totalItems) {
        this.title = title;
        this.authors = authors;
        this.publisher = publisher;
        this.description = description;
        this.publishedDate = publishedDate;
        this.imageThumbnail = imageThumbnail;
        this.totalItems = totalItems;
    }


    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getImageThumbnail() {
        return imageThumbnail;
    }

    public void setImageThumbnail(String imageThumbnail) {
        this.imageThumbnail = imageThumbnail;
    }

    @Override
    public String toString() {
        return "Book{" +
                "books=" + books +
                ", title='" + title + '\'' +
                ", authors=" + Arrays.toString(authors) +
                ", description='" + description + '\'' +
                ", publisher='" + publisher + '\'' +
                ", publishedDate='" + publishedDate + '\'' +
                ", imageThumbnail='" + imageThumbnail + '\'' +
                '}';
    }
}


