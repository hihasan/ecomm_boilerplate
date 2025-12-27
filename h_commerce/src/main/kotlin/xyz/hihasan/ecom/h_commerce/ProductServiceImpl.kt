package xyz.hihasan.ecom.h_commerce

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class ProductServiceImpl(private val productRepository: ProductRepository) : ProductService {
    override fun create(product: ProductModel): ProductModel {
        return productRepository.save(product)
    }

    override fun getById(id: Long): ProductModel {
        return productRepository.findById(id)
            .orElseThrow { IllegalArgumentException("Product not found with id: $id") }
    }

    override fun getAllActive(): List<ProductModel> {
        return productRepository.findAllByActiveTrue()
    }
}