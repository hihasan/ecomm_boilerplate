package xyz.hihasan.ecom.h_commerce

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface ProductRepository : JpaRepository<ProductModel, Long> {
    fun findBySku(sku: String): Optional<ProductModel>

    fun findAllByActiveTrue(): List<ProductModel>
}