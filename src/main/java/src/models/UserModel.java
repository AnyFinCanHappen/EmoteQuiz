package src.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserModel
{
    @JsonProperty(value = "id")
    private String id;

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "displayName")
    private String displayName;

    @JsonProperty(value = "providerId")
    private String providerId;

    @JsonCreator
    public UserModel(@JsonProperty(value = "id") String id, @JsonProperty(value = "name")String name,
                     @JsonProperty(value = "displayName") String displayName, @JsonProperty(value = "providerId") String providerId) {
        this.id = id;
        this.name = name;
        this.displayName = displayName;
        this.providerId = providerId;
    }

    @JsonProperty(value = "id")
    public String getId() {
        return id;
    }

    @JsonProperty(value = "name")
    public String getName() {
        return name;
    }

    @JsonProperty(value = "displayName")
    public String getDisplayName() {
        return displayName;
    }
    @JsonProperty(value = "providerId")
    public String getProviderId() {
        return providerId;
    }
}
