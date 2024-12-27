package models.FavoriteAllDelete;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FavoriteAllDeleteResultBlocksResponseModel {

    @JsonProperty("acknowledged")
    private Boolean acknowledged;

    @JsonProperty("matchedCount")
    private Integer matchedCount;

    @JsonProperty("modifiedCount")
    private Integer modifiedCount;

    @JsonProperty("upsertedCount")
    private Integer upsertedCount;

    @JsonProperty("upsertedId")
    private String upsertedId;
}
