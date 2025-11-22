package com.dgtic.unam.dao;

import com.dgtic.unam.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class BookDAO {

    private SessionFactory sessionFactory;

    public BookDAO() {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Book.class)
                .buildSessionFactory();
    }

    // SELECT * FROM Books WHERE id = :id
    public Book findById(String id) {
        Session session = sessionFactory.openSession();

        Book book = session.get(Book.class, id);

        session.close();
        return book;
    }

    public List<Book> findAll(){
        Session session = sessionFactory.openSession();

        List<Book> books = session
                .createQuery("FROM Book", Book.class)
                .list();

        session.close();
        return books;
    }

    public void save(Book book){
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(book);

        session.getTransaction().commit();
        session.close();
    }

    public void update(Book book){
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.update(book);

        session.getTransaction().commit();
        session.close();
    }

    public void delete(Book book){
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.delete(book);

        session.getTransaction().commit();
        session.close();
    }
}