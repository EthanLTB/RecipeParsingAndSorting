package com.ethanbradley.assignment9;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecipesController {
	@Autowired
	private FileService fileService;

	@GetMapping("/all-recipes")
	public ArrayList<Recipe> allRecipes() {
		return fileService.readFileIntoRecipeCollection();
	}
	
	@GetMapping("/gluten-free")
	public List<Recipe> glutenFree(){
		return fileService.readFileIntoRecipeCollection().stream()
				                                         .filter(e -> e.getGlutenFree().equals(true))
				                                         .collect(Collectors.toList());
	}

	@GetMapping("/vegan")
	public List<Recipe> vegan(){
		return fileService.readFileIntoRecipeCollection().stream()
				                                         .filter(e -> e.getVegan().equals(true))
				                                         .collect(Collectors.toList());
	}
	@GetMapping("/vegan-and-gluten-free")
	public List<Recipe> veganAndGlutenFree(){
		return fileService.readFileIntoRecipeCollection().stream()
														 .filter(e -> e.getGlutenFree().equals(true) && e.getVegan().equals(true))
														 .collect(Collectors.toList());
	}
	@GetMapping("/vegetarian")
	public List<Recipe> vegetarian(){
		return fileService.readFileIntoRecipeCollection().stream()
														 .filter(e -> e.getVegetarian().equals(true))
														 .collect(Collectors.toList());
	}
	
}
