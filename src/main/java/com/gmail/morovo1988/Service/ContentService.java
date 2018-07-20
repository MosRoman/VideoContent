package com.gmail.morovo1988.Service;

import com.gmail.morovo1988.DAO.CategoryDao;
import com.gmail.morovo1988.DAO.ContentDao;
import com.gmail.morovo1988.DAO.LanguageDao;
import com.gmail.morovo1988.Entity.Category;
import com.gmail.morovo1988.Entity.Content;
import com.gmail.morovo1988.Entity.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Pageable;
//import javax.transaction.Transactional;
import java.util.List;

@Service
public class ContentService {
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private ContentDao contentDao;
    @Autowired
    private LanguageDao languageDao;


    @Transactional
    public Content getContentByTitle(String title) {
        return contentDao.findByTitle(title);
    }


    @Transactional
    public boolean existsByTitle(String title) {
        return contentDao.existsByTitle(title);
    }

    @Transactional
    public void addContent(Content content) {
        contentDao.save(content);
    }


    @Transactional
    public void updateContent(Content content) {
        contentDao.save(content);
    }


    @Transactional
    public Content getContentById(long id) {
        return contentDao.findById(id);
    }

    @Transactional
    public Category getCategoryById(long id) {
        return categoryDao.findById(id);
    }

    @Transactional
    public Language getLanguageById(long id) {
        return languageDao.findById(id);
    }


    @Transactional
    public void addCategory(Category category) {
        categoryDao.save(category);
    }

    @Transactional
    public void addLanguage(Language language) {
        languageDao.save(language);
    }

    @Transactional(readOnly = true)
    public List<Category> findCategorys() {
        return categoryDao.findAll();
    }

    @Transactional(readOnly = true)
    public List<Language> findLangusges() {
        return languageDao.findAll();
    }

    @Transactional(readOnly = true)
    public List<Content> findContents() {
        return contentDao.findAll();
    }

    @Transactional(readOnly = true)
    public Content findContent(long id) {
        return contentDao.findOne(id);
    }

    @Transactional(readOnly = true)
    public Category findCategory(long id) {
        return categoryDao.findOne(id);
    }

    @Transactional(readOnly = true)
    public Language findLanguage(long id) {
        return languageDao.findOne(id);
    }

    @Transactional(readOnly = true)
    public List<Content> findAll(Pageable pageable) {
        return contentDao.findAll(pageable).getContent();
    }

    @Transactional(readOnly = true)
    public List<Category> findAllCategory(Pageable pageable) {
        return categoryDao.findAll(pageable).getContent();
    }

    @Transactional(readOnly = true)
    public List<Language> findAllLanguage(Pageable pageable) {
        return languageDao.findAll(pageable).getContent();
    }

    @Transactional(readOnly = true)
    public long count() {
        return contentDao.count();
    }

    @Transactional(readOnly = true)
    public long countCategory() {
        return categoryDao.count();
    }

    @Transactional(readOnly = true)
    public long countLanguage() {
        return languageDao.count();
    }

    @Transactional(readOnly = true)
    public long countByLanguage(Language language) {
        return languageDao.countByLanguage(language);
    }

    @Transactional(readOnly = true)
    public long countByCategory(Category category) {
        return categoryDao.countByCategory(category);
    }

    @Transactional(readOnly = true)
    public List<Content> findByCategory(Category category, Pageable pageable) {
        return contentDao.findByCategory(category, pageable);
    }

    @Transactional(readOnly = true)
    public List<Content> findByLanguage(Language language, Pageable pageable) {
        return contentDao.findByLanguage(language, pageable);
    }

    @Transactional(readOnly = true)
    public List<Content> findByCategory(Category category) {
        return contentDao.findByCategory(category);
    }

    @Transactional(readOnly = true)
    public List<Content> findByLanguage(Language language) {
        return contentDao.findByLanguage(language);
    }

    @Transactional
    public void deleteContent(long id) {
        contentDao.delete(id);
    }

    @Transactional
    public void deleteCategory(long id) {
        categoryDao.delete(id);
    }

    @Transactional
    public void deleteLanguage(long id) {
        languageDao.delete(id);
    }
}
