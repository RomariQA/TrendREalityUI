package models.FavoriteAddBlock;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class FavoriteAddBlockRequestModel {
    private String block_id;
    private String city;
}
