package models.FavoriteAddApartment;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class FavoriteAddApartmentRequestModel {
    private String apartment_id;
    private String city;
}
