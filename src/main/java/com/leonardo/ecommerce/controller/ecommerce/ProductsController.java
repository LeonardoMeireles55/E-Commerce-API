package com.leonardo.ecommerce.controller.ecommerce;

import com.leonardo.ecommerce.domain.ecommerce.Product;
import com.leonardo.ecommerce.record.ecommerce.ProductDTO;
import com.leonardo.ecommerce.service.ecommerce.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductsController {

    private final ProductService productService;

    @GetMapping("/getAllProducts")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductDTO> productDTOs = productService.getAllProducts()
                .stream()
                .map(product -> new ProductDTO(product.getName(),
                        product.getDescription(), product.getPrice(),
                        product.getQuantityInStock(), product.getCategoryEnums(),
                        product.getPhotoLink(), product.getOffPrice(), product.getStars())).toList();

        return ResponseEntity.ok(productDTOs);
    }

    @GetMapping()
    public ResponseEntity<List<Product>> getAllProductsWithId() {
            var productList = productService.getAllProducts();
        return ResponseEntity.ok(productList);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable Long productId) {
        Optional<Product> product = productService.getProductById(productId);
        return ResponseEntity.of(product);
    }

    @PostMapping()
    public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductDTO productDTO) {
        Product createdProduct = productService.createProduct(productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

    @PatchMapping("/incrementStars/{productId}")
    public ResponseEntity<Void> incrementStarsForProduct(@PathVariable Long productId) {
        productService.incrementStarsForProduct(productId);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/decrementStars/{productId}")
    public ResponseEntity<Void> DecrementStarsForProduct(@PathVariable Long productId) {
        productService.decrementStarsForProduct(productId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long productId, @RequestBody ProductDTO productDTO) {
        Product updated = productService.updateProduct(productId, productDTO);
        return ResponseEntity.ok(updated);
    }

    @PatchMapping("/{productId}")
    public ResponseEntity<Product> patchProduct(@PathVariable Long productId, @RequestBody ProductDTO productDTO) {
        Product patchedProduct = productService.patchProduct(productId, productDTO);
        return ResponseEntity.ok(patchedProduct);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
        productService.deleteProductById(productId);
        return ResponseEntity.noContent().build();
    }
}
