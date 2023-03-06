package taco.data;

import org.apache.commons.collections4.IterableUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import taco.Ingredient;
import taco.data.IngredientRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class IngredientRepositoryTest {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Test
    void saveAndFindAll() {
        Ingredient ingredient = new Ingredient("BLKBN", "Black Beans", Ingredient.Type.PROTEIN);

        ingredientRepository.save(ingredient);

        Iterable<Ingredient> result = ingredientRepository.findAll();

        assertTrue(IterableUtils.size(result) > 0);
    }

    @Test
    void findById() {
        Optional<Ingredient> flto = ingredientRepository.findById("FLTO");
        assertTrue(flto.isPresent());
        assertEquals(flto.get(), new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP));

        Optional<Ingredient> xxxx = ingredientRepository.findById("XXXX");
        assertTrue(xxxx.isEmpty());
    }

}
