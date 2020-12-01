package at.htl.karate.control;

import at.htl.karate.entity.Glasses;
import at.htl.karate.entity.User;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
public class UserRepository {

    @Inject
    EntityManager em;


    public List<User> findAll() {

        return em.createNamedQuery("User.findAll", User.class).getResultList();
    }

    public User save(User user) {

        em.persist(user);
        return user;
    }

    public User findById(long id) {

        return em.createNamedQuery("User.findById", User.class).setParameter("id", id).getSingleResult();
    }

    public void delete(long id) {
        em.remove(id);
    }
}