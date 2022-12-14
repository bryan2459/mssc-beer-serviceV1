package bryan2459.msscbeerserviceV1.bootstrap;

import bryan2459.msscbeerserviceV1.domain.Beer;
import bryan2459.msscbeerserviceV1.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    public static final String BEER_1_UPC = "0631234200036";
    public static final String BEER_2_UPC = "0631234300019";
    public static final String BEER_3_UPC = "0083783375213";

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
                   .upc(BEER_1_UPC)
                   .price(new BigDecimal(45.34))
                   .build());

            beerRepository.save(Beer.builder()
                    .beerName("Galaxy cat")
                    .beerStyle("PALE_ALE")
                    .minOnHand(12)
                    .quantityToBrew(200)
                    .upc(BEER_2_UPC)
                    .price(new BigDecimal(12.56))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Kingfisher")
                    .beerStyle("PALE_ALE")
                    .minOnHand(12)
                    .quantityToBrew(200)
                    .upc(BEER_3_UPC)
                    .price(new BigDecimal(10.22))
                    .build());
        }

        System.out.println("Loaded Beers: "+beerRepository.count());
    }
}
