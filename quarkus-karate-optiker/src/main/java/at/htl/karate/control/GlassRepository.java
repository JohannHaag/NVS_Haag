package at.htl.karate.control;

import at.htl.karate.entity.Glasses;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
public class GlassRepository {

    @Inject
    EntityManager em;


    public List<Glasses> findAll() {

        return em.createNamedQuery("Glasses.findAll", Glasses.class).getResultList();
    }

    public Glasses save(Glasses glasses) {

        em.persist(glasses);
        return glasses;
    }

    public Glasses findById(long id) {

        return em.createNamedQuery("Glasses.findById", Glasses.class).setParameter("id", id).getSingleResult();
    }

    public void delete(long id) {
        em.remove(id);
    }
}