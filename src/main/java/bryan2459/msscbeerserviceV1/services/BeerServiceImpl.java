package bryan2459.msscbeerserviceV1.services;

import bryan2459.msscbeerserviceV1.domain.Beer;
import bryan2459.msscbeerserviceV1.repositories.BeerRepository;
import bryan2459.msscbeerserviceV1.web.controller.NotFoundException;
import bryan2459.msscbeerserviceV1.web.mappers.BeerMapper;
import bryan2459.msscbeerserviceV1.web.modal.BeerDto;
import bryan2459.msscbeerserviceV1.web.modal.BeerPagedList;
import bryan2459.msscbeerserviceV1.web.modal.BeerStyleEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service("beerService")
@RequiredArgsConstructor
public class BeerServiceImpl implements BeerService {

    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;

    @Override
    public BeerPagedList listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest pageRequest, Boolean showInventoryOnHand) {
        return null;
    }

    @Override
    public BeerDto getById(UUID beerId) {
        return beerMapper.beerToBeerDto
                (beerRepository.findById(beerId).orElseThrow(NotFoundException::new));
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return beerMapper.beerToBeerDto(beerRepository.save(beerMapper.beerDtoToBeer(beerDto)));
    }

    @Override
    public BeerDto updateBeer(UUID beerId, BeerDto beerDto) {
        Beer beer = beerRepository.findById(beerId).orElseThrow(NotFoundException::new);

        beer.setBeerName(beerDto.getBeerName());
        beer.setBeerStyle(beerDto.getBeerStyle().name());
        beer.setPrice(beerDto.getPrice());
        beer.setUpc(beerDto.getUpc());

        return beerMapper.beerToBeerDto(beerRepository.save(beer));
    }

    @Override
    public BeerDto getByUpc(String upc) {
        return null;
    }
}
