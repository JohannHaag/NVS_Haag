package at.htl.karate.entity

import javax.persistence.*

@Entity
@Table(name = "S_User")
@NamedQueries(
        NamedQuery(name="User.findAll",
                query="SELECT u FROM User u "),
        NamedQuery(name="User.findById",
                query="SELECT u FROM Glasses u WHERE u.id = :id ")
)
open class User(
        @Id
        @GeneratedValue
        public var id: Long? = null
) {
    open lateinit var firstName: String
    open lateinit var lastName: String

    @OneToMany(cascade = [CascadeType.MERGE, CascadeType.REFRESH], mappedBy = "glassPersons")
    open lateinit var glasses: List<Glasses>
}