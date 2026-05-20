package com.example.omarturki.reposority;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.omarturki.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
