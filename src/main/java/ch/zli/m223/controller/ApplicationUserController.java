package ch.zli.m223.controller;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
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
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.model.ApplicationUser;
import ch.zli.m223.model.Category;
import ch.zli.m223.model.Credential;
import ch.zli.m223.model.Entry;
import ch.zli.m223.service.ApplicationUserService;
import ch.zli.m223.service.CategoryService;
import ch.zli.m223.service.EntryService;
import io.smallrye.jwt.build.Jwt;

@Path("/user")
@Tag(name = "ApplicationUser", description = "Handling of User")
public class ApplicationUserController {

    @Inject
    ApplicationUserService applicationUserService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Index all Users.", description = "Returns a list of all users.")
    public List<ApplicationUser> index() {
        return applicationUserService.findAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Creates a new user.", description = "Creates a new user and returns the newly added user.")
    public ApplicationUser register(ApplicationUser user) {
       return applicationUserService.createApplicationUser(user);
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Logs the user in.", description = "Logs the user in and returns a status code.")
    public Response login(Credential credential) {
        ApplicationUser user = applicationUserService.getApplicationUser(credential.getUsername());
        if (user.password.equals(credential.getPassword())){
            String token =
            Jwt.issuer("https://example.com/issuer") 
                .upn("jdoe@quarkus.io") 
                .groups(new HashSet<>(Arrays.asList("User", "Admin"))) 
                .expiresIn(Duration.ofHours(12))
                .sign();
            return Response
                .ok(credential)
                .cookie(new NewCookie("punchclock", token))
                .header("Authorization", "Bearer " + token)
                .build();
        } else {
            return Response.status(401).build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Deletes a user", description = "Deletes a user and returns status code")
    public Response delete(Long id){
        return applicationUserService.deleteApplicationUser(id);
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public ApplicationUser update(Long id, ApplicationUser user){
        return applicationUserService.updateApplicationUser(id, user);
    }
}
