package at.htl.karate.control;

import at.htl.karate.entity.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {

    @Inject
    EntityManager entityManager;

    public List<User> GetAll(){
        return findAll().list();
    }

    @Transactional
    public User saveUser(User user){
        entityManager.persist(user);
        return user;
    }

    @Transactional
    public User updateUser(User updateuser) {
        return entityManager.merge(updateuser);
    }

    @Transactional
    public User deleteUser(Long id) {
        User user = entityManager.find(User.class,id);
        entityManager.remove(user);
        return user;
    }
}