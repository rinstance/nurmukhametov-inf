package ru.itis.springbootdemo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class FileInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String storageFileName;
    private String originalFileName;
    private String type;
    private Long size;
    private String url;

    public FileInfo() {

    }

    public FileInfo(Long id, String storageFileName, String originalFileName, String type, Long size, String url) {
        this.id = id;
        this.storageFileName = storageFileName;
        this.originalFileName = originalFileName;
        this.type = type;
        this.size = size;
        this.url = url;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStorageFileName(String storageFileName) {
        this.storageFileName = storageFileName;
    }

    public void setOriginalFileName(String originalFileName) {
        this.originalFileName = originalFileName;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public String getStorageFileName() {
        return storageFileName;
    }

    public String getOriginalFileName() {
        return originalFileName;
    }

    public String getType() {
        return type;
    }

    public Long getSize() {
        return size;
    }

    public String getUrl() {
        return url;
    }
}
