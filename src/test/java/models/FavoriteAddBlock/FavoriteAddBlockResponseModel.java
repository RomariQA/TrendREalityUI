package models.FavoriteAddBlock;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FavoriteAddBlockResponseModel {

    @JsonProperty("data")
    private FavoriteAddBlockResponseDataModel data;

    @JsonProperty("error")
    private FavoriteAddBlockResponseErrorModel error;
}
