package com.example.fridgemanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Category {
    @Id
    private String categoryId;

    private String categoryName;
    
    // Getter, Setter
    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    
	@Override
    public String toString() {
        return "Category{" +
                "CategoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }

}
