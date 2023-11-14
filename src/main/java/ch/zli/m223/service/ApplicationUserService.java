package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;


import ch.zli.m223.model.ApplicationUser;

@ApplicationScoped
public class ApplicationUserService {
    @Inject
    private EntityManager entityManager;

    @Transactional
    public ApplicationUser createApplicationUser(ApplicationUser user) {
        entityManager.persist(user);
        return user;
    }

    public List<ApplicationUser> findAll() {
        var query = entityManager.createQuery("FROM ApplicationUser", ApplicationUser.class);
        return query.getResultList();
    }

    @Transactional
    public Response deleteApplicationUser(Long id){
        ApplicationUser user = entityManager.find(ApplicationUser.class, id);
        entityManager.remove(user);
        return Response.status(204).build();
    }

    public ApplicationUser getApplicationUser(Long id){
        return entityManager.find(ApplicationUser.class, id);
    }

    public ApplicationUser getApplicationUser(String username){
        ApplicationUser user = (ApplicationUser) entityManager.createQuery(
            "SELECT u FROM ApplicationUser u WHERE u.username LIKE :username")
            .setParameter("username", username)
            .getSingleResult();
        return user;
    }

    public ApplicationUser updateApplicationUser(Long id, ApplicationUser user){
        user.setId(id);
        return entityManager.merge(user);
    }
}
