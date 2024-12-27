package models.FavoriteAllDelete;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class FavoriteAllDeleteResultResponseModel {

    @JsonProperty("apartments")
    private FavoriteAllDeleteResultApartmentsResponseModel apartments;

    @JsonProperty("blocks")
    private FavoriteAllDeleteResultBlocksResponseModel blocks;
}
