package com.example.fridgemanager.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data 
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long ingredientId;
    private String storageId;
	private String name;
	private String categoryId;
	private String brand;
	private int quantity;
	private LocalDate bestBefore;
	private String ingredientDescription;
	private LocalDate createdAt;
	
    @Override
    public String toString() {
        return "Ingredient{" +
                "ingredientId=" + ingredientId +
                ", storageId='" + storageId + '\'' +
                ", name='" + name + '\'' +
                ", categoryId='" + categoryId + '\'' +
                ", brand='" + brand + '\'' +
                ", quantity=" + quantity +
                ", bestBefore=" + bestBefore +
                ", ingredientDescription='" + ingredientDescription + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
    

}
