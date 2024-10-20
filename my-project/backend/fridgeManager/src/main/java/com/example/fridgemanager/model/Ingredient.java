package com.example.fridgemanager.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long ingredientId;
    private String storageId;
	private String name;
	private String categoryId;
	private String brand;
	private int quantity;
	//private LocalDate bestBefore;
	private String ingredientDescription;
	//private LocalDate createdAt;
	
	/*
	 * 241011
	 * 날짜 표기 문제로 json에 데이터가 안 보이는 건가 싶어서 날짜 받는 형식을 수정
	 * */
	
   @JsonFormat(pattern = "yyyy-MM-dd")  // 날짜 형식 지정
    private LocalDate bestBefore;

    @JsonFormat(pattern = "yyyy-MM-dd")  // 날짜 형식 지정
    private LocalDate createdAt;
	
    
    
	    
    public Long getIngredientId() {
		return ingredientId;
	}




	public void setIngredientId(Long ingredientId) {
		this.ingredientId = ingredientId;
	}




	public String getStorageId() {
		return storageId;
	}




	public void setStorageId(String storageId) {
		this.storageId = storageId;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getCategoryId() {
		return categoryId;
	}




	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}




	public String getBrand() {
		return brand;
	}




	public void setBrand(String brand) {
		this.brand = brand;
	}




	public int getQuantity() {
		return quantity;
	}




	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}




	public String getIngredientDescription() {
		return ingredientDescription;
	}




	public void setIngredientDescription(String ingredientDescription) {
		this.ingredientDescription = ingredientDescription;
	}




	public LocalDate getBestBefore() {
		return bestBefore;
	}




	public void setBestBefore(LocalDate bestBefore) {
		this.bestBefore = bestBefore;
	}




	public LocalDate getCreatedAt() {
		return createdAt;
	}




	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}




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
