package mx.unam.dgtic.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// POJO de entidad
@Entity
@Table(name = "BOOK")
public class Book {
    @Id
    private String isbn;
    @Column(name = "BOOK_NAME")
    private String bookName;
    @Column(name = "PUBLISHER_CODE")
    private String publisherCode;

    public Book(){}

    public Book(String isbn, String bookName, String publisherCode) {
        this.isbn = isbn;
        this.bookName = bookName;
        this.publisherCode = publisherCode;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getPublisherCode() {
        return publisherCode;
    }

    public void setPublisherCode(String publisherCode) {
        this.publisherCode = publisherCode;
    }
}
