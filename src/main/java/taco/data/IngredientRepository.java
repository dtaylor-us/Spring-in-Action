package taco.data;

import org.springframework.data.repository.CrudRepository;
import taco.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
