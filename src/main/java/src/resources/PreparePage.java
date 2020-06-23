package src.resources;

import src.logger.ServiceLogger;
import src.models.PreparedEmoteModel;
import src.models.PreparedEmoteResponse;
import src.models.base.ResponseModel;
import src.models.base.Result;
import src.models.TopEmotesModel;
import src.core.Util;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

@Path("prepare")
public class PreparePage
{
    private final int quizLength = 10;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response PrepareQuiz()
    {
        PreparedEmoteResponse responseModel;
        try {
            List<TopEmotesModel> emotes = Arrays.asList(Util.getBTTVEmotes(TopEmotesModel[].class, 100, 0));
            responseModel = getEmotes(emotes);
            responseModel.setResult(Result.EMOTES_FOUND);
        } catch (IOException e){
            ServiceLogger.LOGGER.warning("BTTV error.");
            responseModel = new PreparedEmoteResponse(null);
            responseModel.setResult(Result.BTTV_ERROR);
        } catch (Exception e){
            ServiceLogger.LOGGER.warning("Server Error");
            responseModel = new PreparedEmoteResponse(null);
            responseModel.setResult(Result.INTERNAL_SERVER_ERROR);
        }
        return responseModel.buildResponse();
    }

    private PreparedEmoteResponse getEmotes(List<TopEmotesModel> emotes){
        Collections.shuffle(emotes);
        int i = 0;
        ArrayList<PreparedEmoteModel> emoteList = new ArrayList<>();
        for(TopEmotesModel emote: emotes){
            emoteList.add(new PreparedEmoteModel(emote.getEmotes().getId(),emote.getEmotes().getCode(),1));
            i++;
            if(i == quizLength - 1)
                break;
        }
        PreparedEmoteModel[] emoteArray = new PreparedEmoteModel[emoteList.size()];
        emoteArray = emoteList.toArray(emoteArray);
        return new PreparedEmoteResponse(emoteArray);
    }



}
