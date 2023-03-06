package taco.data;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import taco.Ingredient;
import taco.Taco;
import taco.TacoOrder;
import taco.data.OrderRepository;

import java.util.Date;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


@DataMongoTest
class OrderRepositoryTest {

    @Autowired
    OrderRepository orderRepo;

    @Test
    void saveOrderWithTwoTacos() {

        Taco taco2 = Taco.builder()
                .name("Taco Two")
                .ingredients(
                        List.of(
                                new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP),
                                new Ingredient("GRBF", "Ground Beef", Ingredient.Type.PROTEIN),
                                new Ingredient("CHED", "Shredded Cheddar", Ingredient.Type.CHEESE)
                        )
                ).build();

        Taco taco1 = Taco.builder()
                .name("Taco One")
                .ingredients(
                        List.of(
                                new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP),
                                new Ingredient("GRBF", "Ground Beef", Ingredient.Type.PROTEIN),
                                new Ingredient("CHED", "Shredded Cheddar", Ingredient.Type.CHEESE)
                        )
                ).build();

        TacoOrder order = TacoOrder.builder()
                .deliveryName("Test McTest")
                .deliveryStreet("1234 Test Lane")
                .deliveryCity("Testville")
                .deliveryState("CO")
                .deliveryZip("80123")
                .ccNumber("4111111111111111")
                .ccExpiration("10/23")
                .ccCVV("123")
                .tacos(List.of(taco1, taco2))
                .placedAt(new Date())
                .build();


        TacoOrder savedOrder = orderRepo.save(order);
        assertNotNull(savedOrder.getId());

        TacoOrder fetchedOrder = orderRepo.findById(savedOrder.getId()).get();

        assertEquals("Test McTest", fetchedOrder.getDeliveryName());
        assertEquals("1234 Test Lane", fetchedOrder.getDeliveryStreet());
        assertEquals("Testville", fetchedOrder.getDeliveryCity());
        assertEquals("CO", fetchedOrder.getDeliveryState());
        assertEquals("80123", fetchedOrder.getDeliveryZip());
        assertEquals("4111111111111111", fetchedOrder.getCcNumber());
        assertEquals("10/23", fetchedOrder.getCcExpiration());
        assertEquals("123", fetchedOrder.getCcCVV());
        assertEquals(fetchedOrder.getPlacedAt().getTime(), savedOrder.getPlacedAt().getTime());
        List<Taco> tacos = fetchedOrder.getTacos();
        assertEquals(2, tacos.size());
//        assertThat(tacos, containsInAnyOrder(taco1, taco2));
//        assertTrue(tacos.containsAll(List.of(taco1, taco2)));
    }
}
