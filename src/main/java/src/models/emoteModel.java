package src.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties
public class emoteModel
{
    @JsonProperty(value = "id")
    private String id;
    @JsonProperty(value = "code")
    private String code;
    @JsonProperty(value = "imageType")
    private String imageType;
    @JsonProperty(value = "user")
    private UserModel user;

    @JsonCreator
    public emoteModel(@JsonProperty(value = "id") String id,
                      @JsonProperty(value = "code")String code,
                      @JsonProperty(value = "imageType")String imageType,
                      @JsonProperty(value = "user") UserModel user) {
        this.id = id;
        this.code = code;
        this.imageType = imageType;
        this.user = user;
    }
    @JsonProperty(value = "id")
    public String getId() {
        return id;
    }
    @JsonProperty(value = "code")
    public String getCode() {
        return code;
    }
    @JsonProperty(value = "imageType")
    public String getImageType() {
        return imageType;
    }
    @JsonProperty(value = "user")
    public UserModel getUser() {
        return user;
    }
}
