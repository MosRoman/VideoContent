package com.gmail.morovo1988.DAO;

import com.gmail.morovo1988.Entity.Category;
import com.gmail.morovo1988.Entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by Дом on 17.07.2018.
 */
public interface LanguageDao extends JpaRepository<Language, Long> {

    @Query("SELECT COUNT(c) FROM Content c WHERE c.language = :language")
    long countByLanguage(@Param("language") Language language);

    @Query("SELECT u FROM Language u where u.id = :id")
    Language findById(@Param("id") long id);
}
