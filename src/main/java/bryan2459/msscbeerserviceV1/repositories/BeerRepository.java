package bryan2459.msscbeerserviceV1.repositories;

import bryan2459.msscbeerserviceV1.domain.Beer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {


}
