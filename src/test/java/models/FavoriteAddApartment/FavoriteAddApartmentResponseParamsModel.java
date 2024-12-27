package models.FavoriteAddApartment;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FavoriteAddApartmentResponseParamsModel {

    @JsonProperty("apartment_id")
    private String apartmentId;
}
