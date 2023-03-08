package taco.data;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import taco.Taco;

import java.util.List;

@RestResource(rel="tacos", path="tacos")
public interface TacoRepository
        extends CrudRepository<Taco, Long> {

    List<Taco> findAll(Pageable pageable);
}
