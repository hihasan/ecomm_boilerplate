package xyz.hihasan.ecom.h_commerce

interface ProductService {
    fun create(product: ProductModel): ProductModel

    fun getById(id: Long): ProductModel

    fun getAllActive(): List<ProductModel>
}