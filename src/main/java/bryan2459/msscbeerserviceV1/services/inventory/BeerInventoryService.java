package bryan2459.msscbeerserviceV1.services.inventory;

import java.util.UUID;
public interface BeerInventoryService {
    Integer getOnhandInventory(UUID beerId);
}
