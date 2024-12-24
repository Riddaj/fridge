package com.example.fridgemanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fridgemanager.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
    // 기본적인 CRUD 메서드 (findById, save, delete 등)은 JpaRepository에서 자동으로 제공됩니다.

    // 예를 들어, categoryId로 Category를 찾을 수 있습니다.
    Category findByCategoryId(String categoryId);
}