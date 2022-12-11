package bryan2459.msscbeerserviceV1.web.controller;

import bryan2459.msscbeerserviceV1.web.modal.BeerDto;
import bryan2459.msscbeerserviceV1.web.modal.BeerStyleEnum;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.UUID;

import static java.util.UUID.randomUUID;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;


    @Test
    void getBeerById() {
        try {
            mockMvc.perform(get("/api/v1/beer/"+ randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void saveNewBeer() throws JsonProcessingException {
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
        BeerDto beerDto = getValidBeerDto();
        String beerDtoJson = objectMapper.writeValueAsString(beerDto);
        try {
            mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID().toString())
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
                .upc(1121211L)
                .build();
     }


    }