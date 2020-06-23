package src.models.base;
import javax.ws.rs.core.Response.Status;

public enum Result
{
    JSON_PARSE_EXCEPTION   (-3, "JSON Parse Exception.",   Status.BAD_REQUEST),
    JSON_MAPPING_EXCEPTION (-2, "JSON Mapping Exception.", Status.BAD_REQUEST),
    INTERNAL_SERVER_ERROR  (-1, "Internal Server Error.",  Status.INTERNAL_SERVER_ERROR),
    BTTV_ERROR  (-4,"BTTV Server Error", Status.OK),
    SUFFICIENT_P_LEVEL  (140, "Sufficient P_Level.",  Status.OK),
    INSUFFICIENT_P_LEVEL  (141, "Insufficient P_Level.",  Status.OK),
    STATUS_OK   (200,"Status Ok", Status.OK),
    EMOTES_FOUND    (210, "Emotes Found", Status.OK);

    private final int resultCode;
    private final String message;
    private final Status status;

    Result(int resultCode, String message, Status status)
    {
        this.resultCode = resultCode;
        this.message = message;
        this.status = status;
    }

    public int getResultCode()
    {
        return resultCode;
    }

    public String getMessage()
    {
        return message;
    }

    public Status getStatus()
    {
        return status;
    }
}
