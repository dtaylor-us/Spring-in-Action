package taco.data;

import org.springframework.data.repository.CrudRepository;
import taco.TacoOrder;

public interface OrderRepository extends CrudRepository<TacoOrder, String> {
}
