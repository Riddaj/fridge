package com.example.fridgemanager.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.fridgemanager.model.Ingredient;
import com.example.fridgemanager.repository.IngredientRepository;

@Service
public class IngredientService {

	@Autowired
	private IngredientRepository ingredientRepository;
    
    public List<Ingredient> findByStorageId(String storageId) {
    	List<Ingredient> ingredients = ingredientRepository.findByStorageId(storageId);
    	System.out.println("################### -----ingredients----- ###########################" + ingredients); // 로그 추가
        // storageId에 따라 데이터를 필터링하는 로직
    	return ingredientRepository.findByStorageId(storageId);
    }
    
}
