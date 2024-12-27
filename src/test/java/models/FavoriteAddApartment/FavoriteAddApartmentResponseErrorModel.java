package models.FavoriteAddApartment;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import models.FavoriteAddBlock.FavoriteAddBlockResponseParamsModel;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FavoriteAddApartmentResponseErrorModel {

    @JsonProperty("code")
    private Integer code;

    @JsonProperty("description")
    private String description;

    @JsonProperty("params")
    private FavoriteAddApartmentResponseParamsModel params;
}
