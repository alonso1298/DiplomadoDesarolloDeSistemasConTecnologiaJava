package mx.unam.dgtic;

import mx.unam.dgtic.dao.BookDAO;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        BookDAO bookDAO = new BookDAO();
        var book = bookDAO.findById("ISBN-001");

        System.out.println("Book: " + book.getBookName() + ", ISBN: " + book.getIsbn() + ", Publisher Code: " + book.getPublisherCode());
    }
}