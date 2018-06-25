package de.gedoplan.jackson.resource;

import de.gedoplan.jackson.entity.Talk;
import de.gedoplan.jackson.persistence.TalkRepository;
import io.swagger.annotations.Api;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author GEDOPLAN, Dominik Mathmann
 */
@Api
@Path("talk")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class TalkResource {

    @Inject
    TalkRepository talkRepository;

    @GET
    public List<Talk> getTalks() {
        List<Talk> allTalks = this.talkRepository.findAll();
        return allTalks;
    }

    @GET
    @Path("{id}")
    public Talk getTalk(@PathParam("id") Integer id) {
        Talk talk = this.talkRepository.findById(id);
        if (talk == null) {
            throw new NotFoundException();
        }
        return talk;
    }

    @PUT
    @Path("{id}")
    public void updateTalk(@PathParam("id") Integer id, Talk talk) {
        if (!id.equals(talk.getId())) {
            throw new BadRequestException("id of updated object must be unchanged");
        }

        this.talkRepository.merge(talk);
    }
}
