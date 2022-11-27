package bryan2459.msscbeerserviceV1.bootstrap;

import bryan2459.msscbeerserviceV1.domain.Beer;
import bryan2459.msscbeerserviceV1.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        loadBeerObjects();

    }

    private void loadBeerObjects() {

        if (beerRepository.count() == 0)
        {
           beerRepository.save(Beer.builder()
                   .beerName("Anchor beer")
                   .beerStyle("IPA")
                   .minOnHand(12)
                   .quantityToBrew(200)
                   .upc(12345678901L)
                   .price(new BigDecimal(45.34))
                   .build());

            beerRepository.save(Beer.builder()
                    .beerName("Galaxy cat")
                    .beerStyle("PALE_ALE")
                    .minOnHand(12)
                    .quantityToBrew(200)
                    .upc(123456789041L)
                    .price(new BigDecimal(12.56))
                    .build());
        }

        System.out.println("Loaded Beers: "+beerRepository.count());
    }
}
