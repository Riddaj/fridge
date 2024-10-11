package com.example.fridgemanager.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


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
