package mx.unam.dgtic.entities;

import java.io.Serializable;
import java.util.Objects;

public class ChapterPK implements Serializable {
    private String bookISBN;
    private int chapterNum;

    public ChapterPK() {}

    public ChapterPK(String bookISBN, int chapterNum) {
        this.bookISBN = bookISBN;
        this.chapterNum = chapterNum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookISBN, chapterNum);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ChapterPK other = (ChapterPK) obj;
        return chapterNum == other.chapterNum &&
                Objects.equals(bookISBN, other.bookISBN);
    }
}
