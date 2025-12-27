package xyz.hihasan.ecom.h_commerce.product.domain.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import xyz.hihasan.ecom.h_commerce.product.domain.model.ProductModel
import java.util.Optional

@Repository
interface ProductRepository : JpaRepository<ProductModel, Long> {
    fun findBySku(sku: String): Optional<ProductModel>

    fun findAllByActiveTrue(): List<ProductModel>
}