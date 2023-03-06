package taco.data;

import org.springframework.data.repository.CrudRepository;
import taco.Taco;

public interface TacoRepository
        extends CrudRepository<Taco, Long> {

}
