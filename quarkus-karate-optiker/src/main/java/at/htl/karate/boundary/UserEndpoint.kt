package at.htl.karate.boundary

import at.htl.karate.control.UserRepository
import at.htl.karate.entity.User
import org.hibernate.PersistentObjectException
import javax.inject.Inject
import javax.persistence.PersistenceContext
import javax.persistence.PersistenceException
import javax.transaction.Transactional
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
class UserEndpoint {

    @Inject
    lateinit var userDao: UserRepository

    @GET
    fun findAll(): List<User>{
        return userDao.findAll();
    }

    @GET
    @Path("{id}")
    fun getById(@PathParam("id") id: Long): Response {
        val quote = quoteDao.findById(id) ?: return Response.noContent().build()
        return Response.ok(quote).build()
    }

    @POST
    @Transactional
    fun create(user: User): Response {
        userDao.save(user)
        return Response.ok(user).build()
    }


    @PUT
    fun update(user: User): User {
        return userRepository.updateUser(user)
    }

    @PUT
    @Transactional
    @Path("{id}")
    fun update(@PathParam("id") id: Long, quote: Quote): Quote {
        quote.id = id
        quoteDao.mergeAndFlush(quote)
        quoteDao.refresh(quote)
        return quote
    }

    @DELETE
    @Transactional
    fun delete(quote: Quote): Quote {
        quoteDao.delete(quote)
        return quote
    }

    @DELETE
    @Path("{id}")
    @Transactional
    fun delete(@PathParam("id") id: Long): Quote {
        val quote = quoteDao.findById(id);
        quoteDao.delete(quote)
        return quote
    }
}
