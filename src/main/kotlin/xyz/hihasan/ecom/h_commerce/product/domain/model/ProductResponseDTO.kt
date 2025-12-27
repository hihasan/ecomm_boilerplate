package xyz.hihasan.ecom.h_commerce.product.domain.model

import java.math.BigDecimal

data class ProductResponseDTO(
    val id: Long,
    val name: String,
    val sku: String,
    val price: BigDecimal,
    val quantity: Int,
    val active: Boolean
){

}