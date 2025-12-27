package xyz.hihasan.ecom.h_commerce
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.OffsetDateTime

@Entity
@Table(name = "tbl_product")
data class ProductModel (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false, unique = true)
    val sku: String,

    @Column(nullable = false)
    val price: BigDecimal,

    @Column(nullable = false)
    val quantity: Int,

    @Column(length = 500)
    val description: String? = null,

    @Column(nullable = false)
    val active: Boolean = true,

    @Column(nullable = false)
    val createdAt: OffsetDateTime = OffsetDateTime.now(),

    @Column(nullable = false)
    val updatedAt: OffsetDateTime = OffsetDateTime.now()
)