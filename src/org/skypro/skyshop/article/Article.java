package org.skypro.skyshop.article;

import org.skypro.skyshop.tools.Searchable;

public class Article implements Searchable {
    private final String name;
    private final String content;


    public Article(String name, String content) {
        this.name = name;
        this.content = content;
    }

    @Override
    public String toString() {
        return getName() + "\n" + getContent() + "\n";
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

    public String getContent() {
        return content;
    }
}