package com.example.fridgemanager.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.fridgemanager.model.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
	List<Ingredient> findByStorageId(String storageId);
}