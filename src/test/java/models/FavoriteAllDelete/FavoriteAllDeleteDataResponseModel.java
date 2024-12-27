package models.FavoriteAllDelete;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FavoriteAllDeleteDataResponseModel {

    @JsonProperty("result")
    private FavoriteAllDeleteResultResponseModel result;

    @JsonProperty("favorite_last_modified_at")
    private String favoriteLastModifiedAt;
}
