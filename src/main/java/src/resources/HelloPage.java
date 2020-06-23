package src.resources;

import src.base.Result;
import src.models.HelloResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("hello")
public class HelloPage
{
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response hello()
    {
        HelloResponse responseModel = new HelloResponse("Hello");
        responseModel.setResult(Result.STATUS_OK);
        return responseModel.buildResponse();
    }

}
