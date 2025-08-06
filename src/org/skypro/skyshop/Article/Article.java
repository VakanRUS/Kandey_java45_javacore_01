package org.skypro.skyshop.Article;

import org.skypro.skyshop.Tools.Searchable;

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
}
