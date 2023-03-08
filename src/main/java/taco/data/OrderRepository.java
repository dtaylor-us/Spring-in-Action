package taco.data;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import taco.TacoOrder;
import taco.User;

import java.util.List;

public interface OrderRepository
        extends CrudRepository<TacoOrder, Long> {

     List<TacoOrder> findByUserOrderByPlacedAtDesc(User user, Pageable pageable);
}
