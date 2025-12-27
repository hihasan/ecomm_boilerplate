package xyz.hihasan.ecom.h_commerce.product.extension

import xyz.hihasan.ecom.h_commerce.product.domain.model.ProductModel
import xyz.hihasan.ecom.h_commerce.product.domain.model.ProductResponseDTO

fun ProductModel.toResponse() = ProductResponseDTO(
    id = id,
    name = name,
    sku = sku,
    price = price,
    quantity = quantity,
    active = active
)