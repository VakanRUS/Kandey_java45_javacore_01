
package org.skypro.skyshop.tools;

public class SearchEngine {

    private Searchable[] search;

    public SearchEngine(int size) {
        search = new Searchable[size];
    }

    public void add(Searchable searched) {
        for (int i = 0; i < search.length; i++) {
            if (search[i] == null) {
                search[i] = searched;
                break;
            }
        }
    }

    public Searchable[] search(String searchTerm){
        Searchable[] found = new Searchable[5];
        int i = 0;
        for (Searchable searched : search) {
            if (i==5 || search == null) {
                break;
            }
            else if (searched.getSearchTerm().toLowerCase().contains(searchTerm.toLowerCase())) {
                found[i++] = searched;
            }
        }
        return found;
    }
}