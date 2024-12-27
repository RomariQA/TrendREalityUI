package models.FavoriteAllDelete;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class FavoriteAllDeleteResponseModel {
    @JsonProperty("data")
    private FavoriteAllDeleteDataResponseModel data;

    @JsonProperty("error")
    private String error;
}
