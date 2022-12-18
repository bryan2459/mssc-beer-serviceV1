package bryan2459.msscbeerserviceV1.web.mappers;


import bryan2459.msscbeerserviceV1.domain.Beer;
import bryan2459.msscbeerserviceV1.web.modal.BeerDto;
import org.mapstruct.Mapper;
import org.mapstruct.DecoratedWith;

@Mapper(uses = {DateMapper.class})
@DecoratedWith(BeerMapperDecorator.class)
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

    BeerDto beerToBeerDtoWithInventory(Beer beer);
    Beer beerDtoToBeer(BeerDto dto);
}
