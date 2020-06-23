package src.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TopEmotesModel
{
    @JsonProperty(value = "emote")
    private emoteModel emote;

    @JsonProperty(value = "total")
    private Integer total;

    @JsonCreator
    public TopEmotesModel(@JsonProperty(value = "emotes") emoteModel emote,
                          @JsonProperty(value = "total") Integer total) {
        this.emote = emote;
        this.total = total;
    }
    @JsonProperty(value = "emotes")
    public emoteModel getEmotes() {
        return emote;
    }
    @JsonProperty(value = "total")
    public Integer getTotal() {
        return total;
    }
}
