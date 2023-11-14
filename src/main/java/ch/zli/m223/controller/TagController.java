package ch.zli.m223.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;

import ch.zli.m223.model.Tag;
import ch.zli.m223.service.TagService;

@Path("/tag")
public class TagController {

    @Inject
    TagService tagService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Index all Entries.", description = "Returns a list of all entries.")
    public List<Tag> index() {
        return tagService.findAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Creates a new Tag.", description = "Creates a new Tag and returns the newly added Tag.")
    public Tag create(Tag tag) {
       return tagService.createTag(tag);
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Deletes a Tag", description = "Deletes a Tag and returns a status code")
    public Response delete(Long id){
        return tagService.deleteTag(id);
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Tag update(Long id, Tag tag){
        return tagService.updateTag(id, tag);
    }
}
