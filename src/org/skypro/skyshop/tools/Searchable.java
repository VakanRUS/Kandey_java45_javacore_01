package org.skypro.skyshop.tools;

public interface Searchable {
    String getSearchTerm();

    String getName();

    String getContentType();

    default String getStringRepresentation() {
        return getName() + " " + getContentType() + "\n";
    }
}