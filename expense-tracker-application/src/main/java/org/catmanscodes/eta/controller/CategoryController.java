package org.catmanscodes.eta.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.catmanscodes.eta.dto.CategoryDto;
import org.catmanscodes.eta.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "CATEGORY CRUD REST APIs",
        description = "Category REST Apis : Create Category, Read Category & Category List, Update Category, Delete Category, "
)
@AllArgsConstructor
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private CategoryService categoryService;
    //@AllArgsConstructor to reduce the boilerplate code

    // 1. Create Category REST API

    @Operation(
            summary = "Create Category Rest API",
            description = "Create new category in database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP STATUS CODE 201 CREATED"
    )
    @PostMapping("/create")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {

        return new ResponseEntity<CategoryDto>(categoryService.createCategory(categoryDto), HttpStatus.CREATED);
    }

    // 2. Get Category By ID

    @Operation(
            summary = "Get Category Rest API",
            description = "Get category by id from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS CODE 200 OK"
    )
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable("id") Long id) {

        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }

    // 3. Get All Category
    @Operation(
            summary = "Get ALL Category Rest API",
            description = "Get All category List from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS CODE 200 OK"
    )
    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategory(){

        return ResponseEntity.ok(categoryService.getAllCategory());
    }

    // 4. Update Category
    @Operation(
            summary = "Update Category Rest API",
            description = "Update category by id from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS CODE 200 OK"
    )
    @PutMapping("/{id}/update")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable("id") Long id,@RequestBody CategoryDto categoryDto ){

        return ResponseEntity.ok(categoryService.updateCategory(id,categoryDto));
    }
    @Operation(
            summary = "Delete Category Rest API",
            description = "Get category by id from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS CODE 200 OK"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") Long id){

        categoryService.deleteCategory(id);

        return ResponseEntity.ok("Category has been deleted successfully.");
    }

}
