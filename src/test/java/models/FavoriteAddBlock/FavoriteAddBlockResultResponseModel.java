package models.FavoriteAddBlock;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FavoriteAddBlockResultResponseModel {

    @JsonProperty("block_id")
    private String blockId;

    @JsonProperty("city")
    private String city;

    @JsonProperty("createdAt")
    private String createdAt;

    @JsonProperty("created_at")
    private String created_At;

    @JsonProperty("delete_reason")
    private String deleteReason;

    @JsonProperty("deleted")
    private Boolean deleted;

    @JsonProperty("manager_id")
    private String managerId;

    @JsonProperty("self")
    private Boolean self;

    @JsonProperty("session")
    private String session;

    @JsonProperty("updated_at")
    private String updatedAt;

    @JsonProperty("view")
    private Integer view;

    @JsonProperty("view_at")
    private String viewAt;

    @JsonProperty("__v")
    private String version;

    @JsonProperty("_id")
    private String id;
}
