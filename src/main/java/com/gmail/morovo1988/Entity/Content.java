package com.gmail.morovo1988.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="Content")
@NoArgsConstructor
@Getter
@Setter
public class Content {
    @Id
    @GeneratedValue
    private long  id;

    private String title;
    private String description;

    @ManyToOne
    @JoinColumn(name = "language_id")
    private  Language language;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private String url;

    public Content(String title, String description, String url) {
        this.title = title;
        this.description = description;
        this.url = url;
    }

    public Content(String title, String description, Language language, String url) {
        this.title = title;
        this.description = description;
        this.language = language;
        this.url = url;
    }

    public Content(String title, String description, Category category, String url) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.url = url;
    }

    public Content(String title, String description, Language language, Category category, String url) {
        this.title = title;
        this.description = description;
        this.language = language;
        this.category = category;
        this.url = url;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
