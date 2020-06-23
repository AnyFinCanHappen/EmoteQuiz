package src.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import src.base.ResponseModel;

public class HelloResponse extends ResponseModel {
    @JsonProperty(value = "message", required = true)
    private String message;

    @JsonCreator
    public HelloResponse(@JsonProperty(value = "message", required = true) String message ) {
        this.message = message;
    }

    @JsonProperty(value = "message")
    public String getMessage() {
        return message;
    }
}
