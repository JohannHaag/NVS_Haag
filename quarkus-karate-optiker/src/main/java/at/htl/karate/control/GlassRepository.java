package at.htl.karate.control;

import at.htl.karate.entity.Glasses;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class GlassRepository implements PanacheRepository<Glasses> {

    @Inject
    EntityManager entityManager;

    public List<Glasses> GetAll(){
        return findAll().list();
    }

    @Transactional
    public Glasses saveGlasses(Glasses glasses){
        entityManager.persist(glasses);
        return glasses;
    }

    @Transactional
    public Glasses updateGlasses(Glasses glasses) {
        return entityManager.merge(glasses);
    }

    @Transactional
    public Glasses deleteGlasses(Long id) {
        Glasses glasses = entityManager.find(Glasses.class,id);
        entityManager.remove(glasses);
        return glasses;
    }
}