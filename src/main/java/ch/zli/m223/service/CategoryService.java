package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;


import ch.zli.m223.model.Category;

@ApplicationScoped
public class CategoryService {
    @Inject
    private EntityManager entityManager;

    @Transactional
    public Category createCategory(Category category) {
        entityManager.persist(category);
        return category;
    }

    public List<Category> findAll() {
        var query = entityManager.createQuery("FROM Category", Category.class);
        return query.getResultList();
    }

    @Transactional
    public Response deleteCategory(Long id){
        Category category = entityManager.find(Category.class, id);
        entityManager.remove(category);
        return Response.status(204).build();
    }

    public Category getCategory(Long id){
        return entityManager.find(Category.class, id);
    }

    public Category updateCategory(Long id, Category category){
        category.setId(id);
        return entityManager.merge(category);
    }
}
