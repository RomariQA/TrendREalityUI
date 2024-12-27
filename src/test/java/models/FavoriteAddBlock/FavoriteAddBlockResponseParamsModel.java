package models.FavoriteAddBlock;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FavoriteAddBlockResponseParamsModel {

    @JsonProperty("block_id")
    private String blockId;
}
