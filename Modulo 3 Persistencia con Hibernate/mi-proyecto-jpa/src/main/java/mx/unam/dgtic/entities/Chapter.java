package mx.unam.dgtic.entities;

import jakarta.persistence.*;

import mx.unam.dgtic.entities.pk.ChapterPK;

@Entity
@Table(name = "CHAPTER")
@IdClass(ChapterPK.class)
public class Chapter {

    @Id
    @Column(name = "BOOK_ISBN"
    )
    private String bookISBN;

    @Id
    @Column(name = "CHAPTER_NUM")
    private int chapterNum;

    @Column(name = "TITLE")
    private String title;

    public Chapter() {}

    public Chapter(String bookISBN, int chapterNum, String title) {
        this.bookISBN = bookISBN;
        this.chapterNum = chapterNum;
        this.title = title;
    }

    public String getBookISBN() {
        return bookISBN;
    }

    public void setBookISBN(String bookISBN) {
        this.bookISBN = bookISBN;
    }

    public int getChapterNum() {
        return chapterNum;
    }

    public void setChapterNum(int chapterNum) {
        this.chapterNum = chapterNum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}