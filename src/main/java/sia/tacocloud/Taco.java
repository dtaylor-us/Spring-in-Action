package sia.tacocloud;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Data
public class Taco {
    @NotNull
    @Size(min=5, message="Name must be at least 5 characters long") private String name;
    private Date createdAt = new Date();
    @Size(min=1, message="You must choose at least 1 ingredient") private List<Ingredient> ingredients = new ArrayList<>();
    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    } }
