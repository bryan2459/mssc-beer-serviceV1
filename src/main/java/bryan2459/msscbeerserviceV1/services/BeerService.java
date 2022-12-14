package bryan2459.msscbeerserviceV1.services;

import bryan2459.msscbeerserviceV1.web.modal.BeerDto;
import bryan2459.msscbeerserviceV1.web.modal.BeerPagedList;
import bryan2459.msscbeerserviceV1.web.modal.BeerStyleEnum;
import org.springframework.data.domain.PageRequest;

import java.util.UUID;

public interface BeerService {
    BeerPagedList listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest pageRequest, Boolean showInventoryOnHand);

    BeerDto getById(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto);

    BeerDto getByUpc(String upc);
}
