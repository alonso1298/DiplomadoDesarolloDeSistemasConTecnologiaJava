package mx.unam.dgtic;

import mx.unam.dgtic.dao.BookDAO;
import mx.unam.dgtic.dao.PublisherDAO;
import mx.unam.dgtic.entities.Book;
import mx.unam.dgtic.entities.Publisher;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        BookDAO bookDAO = new BookDAO();
        PublisherDAO publisherDAO = new PublisherDAO();

        Book book = bookDAO.findById("ISBN-001");
        Publisher publisher = publisherDAO.findById("P001");

        System.out.println("Book: " + book.getBookName() + ", ISBN: " + book.getIsbn() + ", Publisher Code: " + book.getPublisherCode());
        System.out.println("Publisher Name: " + publisher.getPublisherName() + ", Code: " + publisher.getCode());
    }
}