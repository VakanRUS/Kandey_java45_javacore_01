package org.skypro.skyshop.article;

import org.skypro.skyshop.tools.Searchable;

import java.util.Objects;

public class Article implements Searchable {
    private final String name;
    private final String content;


    public Article(String name, String content) {
        this.name = name;
        this.content = content;
    }

    @Override
    public String toString() {
        return name + "\n" + content;
    }

    @Override
    public String getSearchTerm() {
        return toString();
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(getName(), article.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}