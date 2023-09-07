package com.java.fazjaune.learning.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.NotEmpty;

@Table("PHOTOS")
public class Photo {

    @Id
    private Integer id;
    @NotEmpty
    private String fileName;
    @JsonIgnore
    private byte[] data;

    private String contentType;

//    public Photo() {
//
//    }
//
//    public Photo(String id, String fileName) {
//        this.id = id;
//        this.fileName = fileName;
//    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}
