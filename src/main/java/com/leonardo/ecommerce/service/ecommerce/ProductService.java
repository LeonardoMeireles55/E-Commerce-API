package com.leonardo.ecommerce.service.ecommerce;

import java.util.List;
import java.util.Optional;

import com.leonardo.ecommerce.record.ecommerce.ProductDTO;
import org.springframework.stereotype.Service;

import com.leonardo.ecommerce.domain.ecommerce.Product;
import com.leonardo.ecommerce.repository.ecommerce.ProductRepositoryCustom;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepositoryCustom productRepositoryCustom;

    public List<Product> getAllProducts() {
        return productRepositoryCustom.findAll();
    }

    public Optional<Product> getProductById(Long productId) {
        return productRepositoryCustom.findById(productId);
    }

    public Product createProduct(ProductDTO productDTO) {
            var product
                    = new Product
                    (productDTO.name(), productDTO.description(), productDTO.price(),
                            productDTO.quantityInStock(), productDTO.categoryEnums(), productDTO.photoLink(),
                            productDTO.offPrice(), productDTO.stars());

        return productRepositoryCustom.save(product);
    }

    public Product updateProduct(Long productId, ProductDTO updatedProductDTO) {
        Product existingProduct = productRepositoryCustom.getReferenceById(productId);

        existingProduct.setName(updatedProductDTO.name());
        existingProduct.setCategoryEnums(updatedProductDTO.categoryEnums());
        existingProduct.setDescription(updatedProductDTO.description());
        existingProduct.setPhotoLink(updatedProductDTO.photoLink());
        existingProduct.setPrice(updatedProductDTO.price());
        existingProduct.setQuantityInStock(updatedProductDTO.quantityInStock());

        return productRepositoryCustom.save(existingProduct);
    }

    public void deleteProductById(Long productId) {
        productRepositoryCustom.deleteById(productId);
    }

    public Product patchProduct(Long productId, ProductDTO productDTO) {
        Product existingProduct = productRepositoryCustom.getReferenceById(productId);

        existingProduct.setName(productDTO.name());
        existingProduct.setCategoryEnums(productDTO.categoryEnums());
        existingProduct.setDescription(productDTO.description());
        existingProduct.setPhotoLink(productDTO.photoLink());
        existingProduct.setPrice(productDTO.price());
        existingProduct.setQuantityInStock(productDTO.quantityInStock());

        return productRepositoryCustom.save(existingProduct);
    }

    public void incrementStarsForProduct(Long productId) {
        productRepositoryCustom.incrementStarsWhereId(productId);
    }
    public void decrementStarsForProduct(Long productId) {
        productRepositoryCustom.decrementStartsWhereId(productId);
    }

    public Double getPriceById(Long id) {
        var productPrice = productRepositoryCustom.getReferenceById(id);

        return productPrice.getPrice();
    }
}

