package xyz.hihasan.ecom.h_commerce

import io.swagger.v3.oas.annotations.Hidden
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@Tag(name = "Products", description = "Product management  API")
@RestController
@RequestMapping("/api/v1/products")
class ProductController(private val productService: ProductService) {


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createProduct(@RequestBody product: ProductModel): ProductModel {
        return productService.create(product)
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