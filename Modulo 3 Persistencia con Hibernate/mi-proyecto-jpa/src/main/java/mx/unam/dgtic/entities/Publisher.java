package mx.unam.dgtic.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// POJO entidad
@Entity
@Table(name = "PUBLISHER")
public class Publisher {
    @Id
    private String code;
    @Column(name = "PUBLISHER_NAME")
    private String publisherName;

    public Publisher(){}

    public Publisher(String code, String publisherName) {
        this.code = code;
        this.publisherName = publisherName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }
}
