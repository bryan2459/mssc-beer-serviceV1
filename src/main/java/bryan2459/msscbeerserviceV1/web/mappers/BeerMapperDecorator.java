package bryan2459.msscbeerserviceV1.web.mappers;

import bryan2459.msscbeerserviceV1.domain.Beer;
import bryan2459.msscbeerserviceV1.services.inventory.BeerInventoryService;
import bryan2459.msscbeerserviceV1.web.modal.BeerDto;
import org.springframework.beans.factory.annotation.Autowired;
public class BeerMapperDecorator implements BeerMapper{

    private BeerInventoryService beerInventoryService;
    private BeerMapper mapper;

    @Autowired
    public void setBeerInventoryService(BeerInventoryService beerInventoryService) {
        this.beerInventoryService = beerInventoryService;
    }

    @Autowired
    public void setMapper(BeerMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public BeerDto beerToBeerDto(Beer beer) {
        BeerDto dto = mapper.beerToBeerDto(beer);
        dto.setQuantityOnHand(beerInventoryService.getOnhandInventory(beer.getId()));
        return dto;
    }

    @Override
    public Beer beerDtoToBeer(BeerDto beerDto) {
        return mapper.beerDtoToBeer(beerDto);
    }
}
