package at.htl.karate.entity

import javax.persistence.*

@Entity
@Table(name = "S_Glasses")
@NamedQueries(
    NamedQuery(name="Glasses.findAll",
            query="SELECT  g FROM Glasses g "),
    NamedQuery(name="Glasses.findById",
            query="SELECT g FROM Glasses g WHERE g.id = :id ")
)
open class Glasses(
        @Id
        @GeneratedValue
        public var id: Long? = null
) {
    open lateinit var name: String
    open var price: Double = 80.0
    open lateinit var colour: String
    open lateinit var brand: String
    open lateinit var glass_high: String
    open lateinit var glass: String

    @ManyToMany(cascade = [CascadeType.MERGE, CascadeType.REFRESH], fetch = FetchType.EAGER, targetEntity = User::class)
    lateinit var glassPersons: List<User>
}