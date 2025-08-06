package org.skypro.skyshop.Tools;

public interface Searchable {
    String getSearchTerm();

    String getName();

    String getContentType();

    default String getStringRepresentation() {
        return getName() + " " + getContentType() + "\n";
    }
}