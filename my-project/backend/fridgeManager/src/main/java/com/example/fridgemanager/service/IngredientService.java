package com.example.fridgemanager.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fridgemanager.model.Category;
import com.example.fridgemanager.model.Ingredient;
import com.example.fridgemanager.repository.CategoryRepository;
import com.example.fridgemanager.repository.IngredientRepository;

@Service
public class IngredientService {

	@Autowired
	private IngredientRepository ingredientRepository;
	
    @Autowired
    private CategoryRepository categoryRepository;  // CategoryRepository 주입
    
    //재료 insert
    public void addIngredient(Ingredient ingredient) {
    	System.out.println("%%%%%%%%%%%%%%%%% -------- 보이는지 확인 --------%%%%%%%%%%%%%%%%%%");
    	ingredientRepository.save(ingredient);
    }
    
    public List<Ingredient> findByStorageId(String storageId) {
    	List<Ingredient> ingredients = ingredientRepository.findByStorageId(storageId);

    	System.out.println("################### -----ingredients----- ###########################" + ingredients);
    	
    	
        // 각 ingredient에 대해 categoryId로 Category를 조회하여 설정
        for (Ingredient ingredient : ingredients) {
            String categoryId = ingredient.getCategory().getCategoryId();  // categoryId를 가져옴
            Category category = categoryRepository.findByCategoryId(categoryId);  // categoryId로 Category 조회
            ingredient.setCategory(category);  // Ingredient에 Category 설정
            
            System.out.println("################### -----category----- ###########################" + category);
        }
        
        
    	// 로그 추가
        // storageId에 따라 데이터를 필터링하는 로직
    	//return ingredientRepository.findByStorageId(storageId);
        return ingredients;
    }
    
}
