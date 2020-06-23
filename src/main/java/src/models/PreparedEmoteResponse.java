package src.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import src.models.base.ResponseModel;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PreparedEmoteResponse extends ResponseModel {
    @JsonProperty(value = "emotes")
    private PreparedEmoteModel[] emotes;

    @JsonCreator
    public PreparedEmoteResponse(PreparedEmoteModel[] emotes) {
        this.emotes = emotes;
    }


    @JsonProperty(value = "emotes")
    public PreparedEmoteModel[] getEmotes() {
        return emotes;
    }
}
