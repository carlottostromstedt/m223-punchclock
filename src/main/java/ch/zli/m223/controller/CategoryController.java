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
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.model.Category;
import ch.zli.m223.model.Entry;
import ch.zli.m223.service.CategoryService;
import ch.zli.m223.service.EntryService;

@Path("/category")
@Tag(name = "Category", description = "Handling of category")
public class CategoryController {

    @Inject
    CategoryService categoryService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Index all Categories.", description = "Returns a list of all entries.")
    public List<Category> index() {
        return categoryService.findAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Creates a new category.", description = "Creates a new category and returns the newly added category.")
    public Category create(Category category) {
       return categoryService.createCategory(category);
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Deletes a category", description = "Deletes an category and returns status code")
    public Response delete(Long id){
        return categoryService.deleteCategory(id);
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Category update(Long id, Category category){
        return categoryService.updateCategory(id, category);
    }
}
