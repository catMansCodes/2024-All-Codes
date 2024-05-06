package org.catmanscodes.eta.service;

import lombok.AllArgsConstructor;
import org.catmanscodes.eta.dto.CategoryDto;
import org.catmanscodes.eta.entity.Category;
import org.catmanscodes.eta.exception.ResourceNotFoundException;
import org.catmanscodes.eta.mapper.CategoryMapper;
import org.catmanscodes.eta.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;
    // Used @AllArgsConstructor to reduce the boiler plat code

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {

        Category category = categoryRepository.save(CategoryMapper.mapToCategory(categoryDto));

        return CategoryMapper.mapToCategoryDto(category);
    }

    @Override
    public CategoryDto getCategoryById(Long id) {

        Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category not found by this ID."));

        return CategoryMapper.mapToCategoryDto(category);
    }

    @Override
    public List<CategoryDto> getAllCategory() {

        List<Category> categoryList = categoryRepository.findAll();

        List<CategoryDto> categoryDtoList = categoryList.stream()
                .map(category -> CategoryMapper.mapToCategoryDto(category))
                .collect(Collectors.toList());

        return categoryDtoList;
    }

    @Override
    public CategoryDto updateCategory(Long id, CategoryDto categoryDto) {

        Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category not found by this ID."));

        category.setName(categoryDto.name());

        Category savedCategory = categoryRepository.save(category);

        return CategoryMapper.mapToCategoryDto(savedCategory);
    }

    @Override
    public void deleteCategory(Long id) {

        Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category not found by this ID."));

        categoryRepository.deleteById(id);
    }


}
