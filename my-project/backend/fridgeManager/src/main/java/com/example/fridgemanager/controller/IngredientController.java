package com.example.fridgemanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.fridgemanager.model.Ingredient;
import com.example.fridgemanager.service.IngredientService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;
    
    @GetMapping(value ="/{storageId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Ingredient>> getIngredientsByStorage(@PathVariable String storageId) {
        // storageId에 따라 적절한 로직을 수행
    	List<Ingredient> ingredients = ingredientService.findByStorageId(storageId);
    	
    	// ingredients의 각 Ingredient에 대해 categoryName을 출력
    	
        for (Ingredient ingredient : ingredients) {
            if (ingredient.getCategory() != null) {
                System.out.println("######  Category Name  ######  : " + ingredient.getCategory().getCategoryName());
            } else {
                System.out.println("&&&&&&&&&&&Category is null for ingredientId: &&&&&&&&&&&&&&");
            }
        }
        
    	System.out.println("###### storageId ######## : " + storageId);
    	if (ingredients.isEmpty()) {
    		System.out.println("################아니 왜 안되냐고 칵씨################");
            return ResponseEntity.noContent().build(); // 데이터가 없을 경우
        }
    	
    	//System.out.println("################야 나와야 할 거 아니냐고################");
    	System.out.println("############### controller Ingredients: ###############  " + ingredients);  // 응답되는 데이터 확인
        
    	return ResponseEntity.ok(ingredients); // JSON 형식으로 응답
    }
    
    @PostMapping("/addIngredient")
    public ResponseEntity<String> addIngredient(@RequestBody Ingredient ingredient){
    	try {
    		ingredientService.addIngredient(ingredient);  // 서비스 계층에서 데이터 처리
            return ResponseEntity.ok("%%%%%%%%% Ingredient added successfully! %%%%%%%%%");
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("%%%%%%% Failed to add ingredient. %%%%%%%");
		}
    }
}

