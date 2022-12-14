package bryan2459.msscbeerserviceV1.web.controller;

import bryan2459.msscbeerserviceV1.bootstrap.BeerLoader;
import bryan2459.msscbeerserviceV1.services.BeerService;
import bryan2459.msscbeerserviceV1.web.modal.BeerDto;
import bryan2459.msscbeerserviceV1.web.modal.BeerStyleEnum;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static java.util.UUID.randomUUID;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    BeerService beerService;

    @Test
    void getBeerById() {
        given(beerService.getById(any())).willReturn(getValidBeerDto());

        try {
            mockMvc.perform(get("/api/v1/beer/"+ randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void saveNewBeer() throws JsonProcessingException {
        given(beerService.saveNewBeer(any())).willReturn(getValidBeerDto());

        BeerDto beerDto = getValidBeerDto();
        String beerDtoJson = objectMapper.writeValueAsString(beerDto);

        try {
            mockMvc.perform(post("/api/v1/beer/")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(beerDtoJson))
                            .andExpect(status().isCreated());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void updateBeerId() throws JsonProcessingException {
        given(beerService.updateBeer(any(), any())).willReturn(getValidBeerDto());
        BeerDto beerDto = getValidBeerDto();
        String beerDtoJson = objectMapper.writeValueAsString(beerDto);
        try {
            mockMvc.perform(put("/api/v1/beer/" + randomUUID().toString())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(beerDtoJson))
                    .andExpect(status().isNoContent());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    BeerDto getValidBeerDto() {
                return BeerDto.builder()
                .BeerName("Anchor")
                .beerStyle(BeerStyleEnum.ALE)
                .price(new BigDecimal(4.5))
                .upc(BeerLoader.BEER_3_UPC)
                .build();
     }


    }