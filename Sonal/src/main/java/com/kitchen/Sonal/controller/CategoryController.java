package com.kitchen.Sonal.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kitchen.Sonal.exception.ResourceNotFoundException;
import com.kitchen.Sonal.model.Category;
import com.kitchen.Sonal.repository.CategoryRepository;

@RestController
public class CategoryController {
@Autowired
	private CategoryRepository categoryRepository;
	@GetMapping("/category")
	public List<Category> getCategory() {
		return categoryRepository.findAll();
	}
	
	@PostMapping("/category")
	public Category postCategory(@RequestBody Category category) {
		return categoryRepository.save(category);
	}
	
	@PutMapping("/category/{cid}")
	public Category updateCategory(@RequestBody Category category , @PathVariable("cid") long cid) {
		try {
		Category cat=categoryRepository.getOne(cid);
		cat.setName(category.getName());
		return categoryRepository.save(cat);
	}
		
		catch (Exception e) {
			return null;}
		}
	@DeleteMapping("/category/{cid}")
	public void deleteCategory(@PathVariable("cid") long cid) {
		 categoryRepository.deleteById(cid);
	}
}
