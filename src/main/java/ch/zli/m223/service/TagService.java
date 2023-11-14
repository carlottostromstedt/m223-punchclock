package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import ch.zli.m223.model.Tag;

@ApplicationScoped
public class TagService {
    @Inject
    private EntityManager entityManager;

    @Transactional
    public Tag createTag(Tag tag) {
        entityManager.persist(tag);
        return tag;
    }

    public List<Tag> findAll() {
        var query = entityManager.createQuery("FROM Tag", Tag.class);
        return query.getResultList();
    }

    @Transactional
    public Response deleteTag(Long id){
        Tag tag = entityManager.find(Tag.class, id);
        entityManager.remove(tag);
        return Response.status(204).build();
    }

    public Tag getTag(Long id){
        return entityManager.find(Tag.class, id);
    }

    public Tag updateTag(Long id, Tag tag){
        tag.setId(id);
        return entityManager.merge(tag);
    }
}
