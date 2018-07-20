package com.gmail.morovo1988.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Language")
@NoArgsConstructor
@Getter
@Setter
public class Language {

    @Id
    @GeneratedValue
    private long  id;

    private String name;

    private  String shortCode;

    @OneToMany(mappedBy="language", cascade= CascadeType.ALL)
    private List<Content> contents = new ArrayList<>();



    public Language(String name, String shortCode) {
        this.name = name;
        this.shortCode = shortCode;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public List<Content> getContents() {
        return contents;
    }

    public void setContents(List<Content> contents) {
        this.contents = contents;
    }
}
