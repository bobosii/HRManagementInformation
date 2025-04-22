package com.HRManagementInformation.entities;

import jakarta.persistence.*;

@Entity
public class DocumentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String typeName;
    private String description;

    public DocumentType() {
    }

    public DocumentType(int id, String typeName, String description) {
        this.id = id;
        this.typeName = typeName;
        this.description = description;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getTypeName() {
        return typeName;
    }
    
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
}
