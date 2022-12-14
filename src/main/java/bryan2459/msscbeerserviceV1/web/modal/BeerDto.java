package bryan2459.msscbeerserviceV1.web.modal;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {

    @Null
    private UUID id;

    @Null
    private Integer version;

    @Null
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ssZ",shape=JsonFormat.Shape.STRING)
    private OffsetDateTime createDate;

    @Null
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ssZ",shape=JsonFormat.Shape.STRING)
    private OffsetDateTime lastModifiedDate;

    @NotBlank
    private String BeerName;

    @NotNull
    private BeerStyleEnum beerStyle;


    @NotNull
    private String upc;


    @NotNull
    @Positive
    @JsonFormat(shape = JsonFormat.Shape.STRING )
    private BigDecimal price;

    private Integer quantityOnHand;



}
