package com.example.fridgemanager.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	
	//241224 Category클래스 따로 만들어서 기존 주석 처리
	//private String categoryId;
	
    @ManyToOne
    @JoinColumn(name = "categoryId")  // 외래 키 컬럼명
	private Category category;  // Category 객체 추가
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




	/*
	 * public String getCategoryId() { return categoryId; }
	 * 
	 * 
	 * 
	 * 
	 * public void setCategoryId(String categoryId) { this.categoryId = categoryId;
	 * }
	 */
	
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
                ", category='" + category + '\'' +
                ", brand='" + brand + '\'' +
                ", quantity=" + quantity +
                ", bestBefore=" + bestBefore +
                ", ingredientDescription='" + ingredientDescription + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
    

}
