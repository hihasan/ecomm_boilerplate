package xyz.hihasan.ecom.h_commerce.product.domain.service

import xyz.hihasan.ecom.h_commerce.product.domain.model.ProductModel

interface ProductService {
    fun create(product: ProductModel): ProductModel

    fun getById(id: Long): ProductModel

    fun getAllActive(): List<ProductModel>
}