package models.FavoriteAddApartment;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FavoriteAddApartmentResponseModel {

    @JsonProperty("data")
    private FavoriteAddApartmentResponseDataModel data;

    @JsonProperty("error")
    private FavoriteAddApartmentResponseErrorModel error;
}
