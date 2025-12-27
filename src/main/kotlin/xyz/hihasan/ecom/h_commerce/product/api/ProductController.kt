package xyz.hihasan.ecom.h_commerce.product.api

import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import xyz.hihasan.ecom.h_commerce.product.domain.model.CreateProductRequestModel
import xyz.hihasan.ecom.h_commerce.product.domain.model.ProductModel
import xyz.hihasan.ecom.h_commerce.product.domain.model.ProductResponseDTO
import xyz.hihasan.ecom.h_commerce.product.domain.service.ProductService
import xyz.hihasan.ecom.h_commerce.product.extension.toResponse

@Tag(name = "Products", description = "Product management  API")
@RestController
@RequestMapping("/api/v1/products")
final class ProductController(private val productService: ProductService) {


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createProduct(@RequestBody product: CreateProductRequestModel): ProductResponseDTO {
        val product = ProductModel(
            name = product.name,
            sku = product.sku,
            price = product.price,
            quantity = product.quantity,
            description = product.description
        )

        return productService.create(product).toResponse()
    }

//    @Operation(summary = "Get product by ID")
//    @ApiResponses(
//        value = [
//            ApiResponse(
//                responseCode = "200",
//                description = "Product found",
//                content = [
//                    Content(
//                        mediaType = "application/json",
//                        schema = Schema(implementation = ProductResponse::class)
//                    )
//                ]
//            ),
//            ApiResponse(
//                responseCode = "404",
//                description = "Product not found",
//                content = [
//                    Content(
//                        mediaType = "application/json",
//                        schema = Schema(implementation = ApiErrorResponse::class)
//                    )
//                ]
//            ),
//            ApiResponse(
//                responseCode = "500",
//                description = "Internal server error",
//                content = [
//                    Content(
//                        mediaType = "application/json",
//                        schema = Schema(implementation = ApiErrorResponse::class)
//                    )
//                ]
//            )
//        ]
//    )
    @GetMapping("/{id}")
    fun getProduct(@PathVariable id: Long): ProductModel {
        return productService.getById(id)
    }

    @GetMapping
    fun getActiveProducts(): List<ProductModel> {
        return productService.getAllActive()
    }
}