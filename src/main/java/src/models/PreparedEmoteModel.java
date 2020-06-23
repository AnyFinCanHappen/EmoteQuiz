package src.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import src.models.base.ResponseModel;

public class PreparedEmoteModel {
    @JsonProperty(value = "id")
    private String id;
    @JsonProperty(value = "code")
    private String code;
    @JsonProperty(value = "type")
    private Integer type;

    public PreparedEmoteModel(@JsonProperty(value = "id")String id,
                              @JsonProperty(value = "code")String code,
                              @JsonProperty(value = "type")Integer type) {
        this.id = id;
        this.code = code;
        this.type = type;
    }
    @JsonProperty(value = "id")
    public String getId() {
        return id;
    }
    @JsonProperty(value = "code")
    public String getCode() {
        return code;
    }
    @JsonProperty(value = "type")
    public Integer getType() {
        return type;
    }
}
