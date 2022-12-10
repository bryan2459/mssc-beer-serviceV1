package bryan2459.msscbeerserviceV1.web.mappers;


import bryan2459.msscbeerserviceV1.domain.Beer;
import bryan2459.msscbeerserviceV1.web.modal.BeerDto;
import org.mapstruct.Mapper;


@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto dto);
}
