package com.kitchen.Sonal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kitchen.Sonal.model.Category;
import com.kitchen.Sonal.model.Menu;
import com.kitchen.Sonal.repository.CategoryRepository;
import com.kitchen.Sonal.repository.MenuRepository;

@RestController
public class MenuController {
	@Autowired
	private MenuRepository menuRepository;
	@Autowired
	private CategoryRepository categoryRepository;

	@GetMapping("/menu/{cid}")
	public List<Menu> getMenu(@PathVariable("cid") long cid) {
		return menuRepository.findByCategoryId(cid);
	}
	@PostMapping("/menu/{cid}")
	public Menu postMenu(@RequestBody Menu menu,@PathVariable("cid") long cid) {
	Category category=	categoryRepository.getOne(cid);
	 menu.setCategory(category);
	 return menuRepository.save(menu);
	}
	@PutMapping("/menu/{pid}")
	public Menu updateMenu(@RequestBody Menu menu,@PathVariable("pid") long pid) {
	Menu m=menuRepository.getOne(pid);
	m.setPrice(menu.getPrice());;
	m.setName(menu.getName());
	m.setDiscription(menu.getDiscription());
	return menuRepository.save(menu);
	}
	@DeleteMapping("/menu/{pid}")
	public void deleteMenu(@PathVariable("pid") long pid) {
		menuRepository.deleteById(pid);
	}
	@GetMapping("/menu/search/{name}")
	public List<Menu> searchByProductTitle(@PathVariable("name") String name) {
		List<Menu> list=menuRepository.searchByProductTitle(name);
		return list;
	}
}
