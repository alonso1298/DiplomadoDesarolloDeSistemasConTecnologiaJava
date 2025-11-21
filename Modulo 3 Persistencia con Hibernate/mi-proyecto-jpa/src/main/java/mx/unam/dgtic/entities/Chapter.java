package mx.unam.dgtic.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CHAPTER")
public class Chapter {
    @Id
    private String bookIBN;
    @Column(name = "BOOK_ISBN")
    private int chapterNum;
    @Column(name = "TITLE")
    private String title;

    public Chapter(){}

    public Chapter(String bookISBN, int chapterNum, String title) {
        this.bookIBN = bookISBN;
        this.chapterNum = chapterNum;
        this.title = title;
    }

    public String getBookIBN() {
        return bookIBN;
    }

    public void setBookIBN(String bookIBN) {
        this.bookIBN = bookIBN;
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
