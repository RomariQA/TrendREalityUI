package models.FavoriteAddApartment;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class FavoriteAddApartmentResponseDataModel {

    @JsonProperty("favorite_last_modified_at")
    private String favorite_last_modified_at;

    @JsonProperty("result")
    private FavoriteAddApartmentResponseResultModel result;
}
