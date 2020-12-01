package at.htl.karate.control;

import at.htl.karate.entity.Glasses;
import at.htl.karate.entity.User;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@ApplicationScoped
public class InitBean {

    @Inject
    EntityManager em;

    @Transactional
    void init(@Observes StartupEvent ev) {
        System.out.println("It works");

        User user = new User("Haag","Johann" );
        em.persist(user);

        Glasses glasses = new Glasses("Brille1","Blue","Nike",80.0,"80cm",user);
        em.persist(glasses);

    }
}