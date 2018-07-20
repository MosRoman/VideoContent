package com.gmail.morovo1988.DAO;


import com.gmail.morovo1988.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface CategoryDao extends JpaRepository<Category, Long> {
    @Query("SELECT COUNT(c) FROM Content c WHERE c.category = :category")
    long countByCategory(@Param("category") Category category);

    @Query("SELECT u FROM Category u where u.id = :id")
    Category findById(@Param("id") long id);
}
