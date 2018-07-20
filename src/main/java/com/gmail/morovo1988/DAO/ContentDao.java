package com.gmail.morovo1988.DAO;

import com.gmail.morovo1988.Entity.Category;
import com.gmail.morovo1988.Entity.Content;
import com.gmail.morovo1988.Entity.Language;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Дом on 17.07.2018.
 */
public interface ContentDao extends JpaRepository<Content, Long> {
    @Query("SELECT u FROM Content u where u.title = :title")
    Content findByTitle(@Param("title") String title);

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM Content u WHERE u.title = :title")
    boolean existsByTitle(@Param("title") String title);

    @Query("SELECT c FROM Content c WHERE c.category = :category")
    List<Content> findByCategory(@Param("category") Category category, Pageable pageable);

    @Query("SELECT c FROM Content c WHERE c.language = :language")
    List<Content> findByLanguage(@Param("language") Language language, Pageable pageable);

    @Query("SELECT c FROM Content c WHERE c.category = :category")
    List<Content> findByCategory(@Param("category") Category category);

    @Query("SELECT c FROM Content c WHERE c.language = :language")
    List<Content> findByLanguage(@Param("language") Language language);

    @Query("SELECT u FROM Content u where u.id = :id")
    Content findById(@Param("id") long id);
}
