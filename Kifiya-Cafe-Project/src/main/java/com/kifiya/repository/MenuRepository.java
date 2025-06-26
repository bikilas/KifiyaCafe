package com.kifiya.repository;

import com.kifiya.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    
    List<Menu> findByNameContainingIgnoreCase(String name);
    
    List<Menu> findByCategory_Id(Long categoryId);
    
    List<Menu> findByPriceBetween(Double minPrice, Double maxPrice);
    
    List<Menu> findByIsAvailableTrue();
    
    @Query("SELECT m FROM Menu m WHERE LOWER(m.name) LIKE LOWER(CONCAT('%', :name, '%')) OR LOWER(m.category.name) LIKE LOWER(CONCAT('%', :category, '%'))")
    List<Menu> findByNameContainingIgnoreCaseOrCategory_NameContainingIgnoreCase(
            @Param("name") String name,
            @Param("category") String category
    );
}
