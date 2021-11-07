package com.ethanbradley.assignment9;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileService {

	@Autowired
	private RecipeRepository recipeRepository;
	@Autowired
	private RecipeService recipeService;

	public ArrayList<Recipe> readFileIntoRecipeCollection() {

		try {
			Reader in = new FileReader("recipes.txt");
			Iterable<CSVRecord> records = CSVFormat.DEFAULT.withEscape('\\').withFirstRecordAsHeader()
					.withSkipHeaderRecord().withIgnoreSurroundingSpaces().parse(in);

			for (CSVRecord record : records) {

				Recipe recipe = recipeService.createRecipeFromCSVRecord(record);

				recipeRepository.getAllRecipes().add(recipe);

			}
			in.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return recipeRepository.getAllRecipes();
	}

}
