package at.htl.karate.boundary;

import at.htl.karate.control.UserRepository;
import at.htl.karate.entity.User;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/user")
public class UserEndpoint {
    @Inject
    UserRepository userRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public PanacheQuery<User> findAll() {
        return userRepository.findAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public User create(User user) {
        return userRepository.saveUser(user);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public User update(User user) {
        return userRepository.updateUser(user);
    }
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public User delete(User user) {
        return userRepository.deleteUser(user.id);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public User delete(@PathParam("id") long id, User user) {
        user.id = id;
        return userRepository.deleteUser(user.id);
    }
}