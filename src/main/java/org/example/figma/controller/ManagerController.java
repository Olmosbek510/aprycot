package org.example.figma.controller;

import lombok.RequiredArgsConstructor;
import org.example.figma.entity.enums.OrderStatus;
import org.example.figma.model.dto.request.*;
import org.example.figma.model.dto.response.CategoryResDto;
import org.example.figma.model.dto.response.ProductResDto;
import org.example.figma.model.dto.response.UserResDto;
import org.example.figma.service.CategoryService;
import org.example.figma.service.OrderService;
import org.example.figma.service.ProductService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/manager")
public class ManagerController {
    private final CategoryService categoryService;
    private final ProductService productService;
    private final OrderService orderService;

    @GetMapping("category") ResponseEntity<List<CategoryResDto>> getCategories(){return categoryService.getCategories();}

    @GetMapping("product") ResponseEntity<List<ProductResDto>> getProducts(){
        return productService.getAllProducts();
    }

    @PostMapping(value = "category", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> getSavedCategoryName(@ModelAttribute CategoryDto categoryDto,@RequestParam MultipartFile multipartFile) throws IOException {
        return ResponseEntity.ok(categoryService.saveCategory(categoryDto,multipartFile));
    }

    @PutMapping(value = "editCategory", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> editCategory(@ModelAttribute CategoryEditDto categoryEditDto, @RequestParam MultipartFile multipartFile) throws IOException {
        return ResponseEntity.ok(categoryService.editCategory(categoryEditDto,multipartFile));
    }


    @DeleteMapping("category/delete")
    public ResponseEntity<?>deleteCategory(@RequestParam("categoryId") UUID categoryId){
        productService.archiveProductsByCategoryId(categoryId);
        return ResponseEntity.ok(categoryService.archiveCategory(categoryId));
    }

    @PostMapping(value = "product", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> getSavedProductName(@ModelAttribute ProductReqDto productReqDto, @RequestParam MultipartFile multipartFile ) throws IOException {
        return ResponseEntity.ok(productService.saveProduct(productReqDto,multipartFile));
    }

    @PutMapping(value = "editProduct", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> editProduct(@ModelAttribute ProductEditReqDto productEditReqDto,@RequestParam MultipartFile multipartFile) throws IOException {
        return ResponseEntity.ok(productService.editProduct(productEditReqDto,multipartFile));
    }


    @DeleteMapping("product/delete")
    public ResponseEntity<?>deleteProduct(@RequestParam("productId") UUID productId){return ResponseEntity.ok(productService.archiveProduct(productId));}

    @PutMapping("order/{id}")
    public ResponseEntity<?> changeOrderStatus(@PathVariable UUID id, @RequestBody OrderStatus orderStatus){
        String message=orderService.changeStatus(id,orderStatus);
        return ResponseEntity.ok(message);
    }
    @GetMapping("product/{id}")
    public ResponseEntity<?> getProductById(@PathVariable UUID id){
        ProductResDto productResDto=productService.getProductById(id);
        return ResponseEntity.ok(productResDto);
    }

    @GetMapping("product/search")
    public ResponseEntity<?> getProductsBySearch(@RequestParam String example){
        List<ProductResDto> productResDtos=productService.search(example);
        return ResponseEntity.ok(productResDtos);
    }
}
