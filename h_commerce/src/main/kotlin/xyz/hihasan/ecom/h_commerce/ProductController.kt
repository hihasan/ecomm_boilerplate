package xyz.hihasan.ecom.h_commerce

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/products")
class ProductController(private val productService: ProductService) {


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createProduct(@RequestBody product: ProductModel): ProductModel {
        return productService.create(product)
    }

    @GetMapping("/{id}")
    fun getProduct(@PathVariable id: Long): ProductModel {
        return productService.getById(id)
    }

    @GetMapping
    fun getActiveProducts(): List<ProductModel> {
        return productService.getAllActive()
    }
}