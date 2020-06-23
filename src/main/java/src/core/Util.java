package src.core;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import src.logger.ServiceLogger;
import src.models.base.*;
import org.glassfish.jersey.jackson.JacksonFeature;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

public class Util
{
    private static final ObjectMapper MAPPER = new ObjectMapper();


    public static <T, S extends ResponseModel> T modelMapper(
            String jsonString, Class<T> className, S responseModel)
    {
        ServiceLogger.LOGGER.info("Mapping object from String");
        try {
            return MAPPER.readValue(jsonString, className);
        } catch (IOException e) {
            setException(e, responseModel);
        }
        ServiceLogger.LOGGER.info("Mapping Object Failed: " + responseModel.getResult());
        return null;
    }

    private static <S extends ResponseModel> void setException(IOException e, S responseModel)
    {
        if (e instanceof JsonMappingException) {
            responseModel.setResult(Result.JSON_MAPPING_EXCEPTION);

        } else if (e instanceof JsonParseException) {
            responseModel.setResult(Result.JSON_PARSE_EXCEPTION);

        } else {
            responseModel.setResult(Result.INTERNAL_SERVER_ERROR);
        }
    }

    public static <T> T modelMapper(String jsonString, Class<T> className)
    {
        ObjectMapper mapper = new ObjectMapper();

        ServiceLogger.LOGGER.info("Mapping object");
        try {
            return mapper.readValue(jsonString, className);
        } catch (IOException e) {
            ServiceLogger.LOGGER.info("Mapping Object Failed: " + e.getMessage());
            return null;
        }
    }


    public static <T> T getBTTVEmotes(Class<T> className,int limit, int offset) throws IOException
    {
        ServiceLogger.LOGGER.info("Building client...");
        Client client = ClientBuilder.newClient();
        client.register(JacksonFeature.class);
        WebTarget webTarget = client.target("https://api.betterttv.net/3/").path("emotes/shared/top")
                .queryParam("limit",limit)
                .queryParam("offset",offset);

        // Create an InvocationBuilder to create the HTTP request
        ServiceLogger.LOGGER.info("Starting invocation builder...");
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        // Send the request and save it to a Response
        ServiceLogger.LOGGER.info("Sending request...");
        //Response response = invocationBuilder.post(Entity.entity(requestModel, MediaType.APPLICATION_JSON));
        Response response = invocationBuilder.get();
        ServiceLogger.LOGGER.info("Request sent.");
        ServiceLogger.LOGGER.info("Received status " + response.getStatus());
        if(response.getStatus() != 200){
            throw new IOException();
        }
        String jsonText = response.readEntity(String.class);
        //ServiceLogger.LOGGER.info(jsonText);
        return modelMapper(jsonText, className);
    }


}

