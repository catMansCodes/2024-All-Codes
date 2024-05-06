package org.catmanscodes.eta.mapper;

import org.catmanscodes.eta.dto.CategoryDto;
import org.catmanscodes.eta.entity.Category;

public class CategoryMapper {

    public static Category mapToCategory(CategoryDto categoryDto) {

        return new Category(
                categoryDto.id(),
                categoryDto.name()
        );
    }

    public static CategoryDto mapToCategoryDto(Category category) {

        return new CategoryDto(
                category.getId(),
                category.getName()
        );
    }

}
