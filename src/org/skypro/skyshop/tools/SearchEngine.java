
package org.skypro.skyshop.tools;

import org.skypro.skyshop.Exceptions.BestResultNotFound;

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

    public Searchable[] search(String searchTerm) {
        Searchable[] found = new Searchable[5];
        int i = 0;
        for (Searchable searched : search) {
            if (i == 5 || searched == null) {
                break;
            } else if (searched.getSearchTerm().toLowerCase().contains(searchTerm.toLowerCase())) {
                found[i++] = searched;
            }
        }
        return found;
    }

    public Searchable searchBestResult(String searchTerm) throws BestResultNotFound {

        int maxMatchesFounded = 0;
        Searchable bestResult = null;
        String tempString;

        for (Searchable found : search) {

            if (found != null) {
                tempString = found.getSearchTerm().toLowerCase();
                int counter = 0;
                int index = 0;
                int indexOfFoundedMatch = tempString.indexOf(searchTerm.toLowerCase(), index);
                while (indexOfFoundedMatch != -1) {
                    index = indexOfFoundedMatch + searchTerm.length();
                    indexOfFoundedMatch = tempString.indexOf(searchTerm.toLowerCase(), index);
                    counter++;
                }
                if (counter > maxMatchesFounded) {
                    maxMatchesFounded = counter;
                    bestResult = found;
                }
            }
        }

        if (bestResult == null) {
            throw new BestResultNotFound("Нет совпадений по слову - " + searchTerm);
        } else {
            return bestResult;
        }
    }
}