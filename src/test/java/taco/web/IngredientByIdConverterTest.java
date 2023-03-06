package taco.web;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import taco.Ingredient;
import taco.data.IngredientRepository;
import taco.web.IngredientByIdConverter;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class IngredientByIdConverterTest {

    private IngredientByIdConverter converter;

    @BeforeEach
    void setup() {
        IngredientRepository ingredientRepository = mock(IngredientRepository.class);
        when(ingredientRepository.findById("AAA"))
                .thenReturn(Optional.of(new Ingredient("AAA", "Test Ingredient", Ingredient.Type.PROTEIN)));

        when(ingredientRepository.findById("XXX"))
                .thenReturn(Optional.empty());

        this.converter = new IngredientByIdConverter(ingredientRepository);
    }

    @Test
    void shouldReturnValueWhenPresent() {
        Ingredient result = converter.convert("AAA");
        assertEquals(new Ingredient("AAA", "Test Ingredient", Ingredient.Type.PROTEIN), result);
    }
    @Test
    void shouldReturnNullWhenMissing() {
        Ingredient result = converter.convert("XXX");
        assertNull(result);
    }
}
