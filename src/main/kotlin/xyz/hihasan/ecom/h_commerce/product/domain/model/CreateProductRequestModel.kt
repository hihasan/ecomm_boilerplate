package xyz.hihasan.ecom.h_commerce.product.domain.model

import java.math.BigDecimal

data class CreateProductRequestModel(
    val name: String,
    val sku: String,
    val price: BigDecimal,
    val quantity: Int,
    val description: String?
)