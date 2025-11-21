package mx.unam.dgtic.entities;

import jakarta.persistence.Id;


public class Chapter {
    @Id
    private String bookIBN;

    private int chapterNum;
    private String title;

    public Chapter(){}

    public Chapter(String bookIBN, int chapterNum, String title) {
        this.bookIBN = bookIBN;
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
