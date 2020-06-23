package src.resources;

import src.base.Result;
import src.logger.ServiceLogger;
import src.models.HelloResponse;
import src.models.TopEmotesModel;
import src.core.Util;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("Prepare")
public class PreparePage
{
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response PrepareQuiz()
    {
        TopEmotesModel[] emotes = Util.getBTTVEmotes(TopEmotesModel[].class);
        ServiceLogger.LOGGER.info("Size: " + emotes.length);
        HelloResponse responseModel = new HelloResponse("Hello");
        responseModel.setResult(Result.STATUS_OK);
        return responseModel.buildResponse();
    }

}
