package at.htl.karate.boundary;


import at.htl.karate.control.GlassRepository;
import at.htl.karate.control.UserRepository;
import at.htl.karate.entity.Glasses;
import at.htl.karate.entity.User;
import io.quarkus.hibernate.orm.panache.PanacheQuery;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/glasses")
public class GlassEndpoint {
    @Inject
    GlassRepository glassRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public PanacheQuery<Glasses> findAll() {
        return glassRepository.findAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Glasses create(Glasses glasses) {
        return glassRepository.saveGlasses(glasses);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Glasses update(Glasses glasses) {
        return glassRepository.updateGlasses(glasses);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Glasses delete(Glasses glasses) {
        return glassRepository.deleteGlasses(glasses.id);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Glasses delete(@PathParam("id") long id, Glasses glasses) {
        glasses.id = id;
        return glassRepository.deleteGlasses(glasses.id);
    }
}
