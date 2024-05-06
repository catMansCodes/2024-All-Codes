package org.catmanscodes.eta.repository;

import org.catmanscodes.eta.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    //spring data jpa provides implementation for this interface
    //spring data jpa will provide an inbuilt CRUD methods
    //spring data jpa manage the transaction for all CRUD operations

}
