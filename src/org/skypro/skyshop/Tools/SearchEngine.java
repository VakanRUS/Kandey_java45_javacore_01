
package org.skypro.skyshop.Tools;

import org.skypro.skyshop.Exceptions.BestResultNotFound;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {

    private Set<Searchable> searchTerms;

    public SearchEngine(int size) {
        searchTerms = new HashSet<>();
    }

    public void add(Searchable searched) {
        searchTerms.add(searched);
    }

    public Set<Searchable> search(String searchTerm) {
        return searchTerms.stream()
                .filter(Objects::nonNull)
                .filter(searchElement -> searchElement.getSearchTerm().toLowerCase().contains(searchTerm.toLowerCase()))
                .collect(Collectors.toCollection(() -> new TreeSet<>(new org.skypro.skyshop.Tools.MyComparator())));
    }

    public Searchable searchBestResult(String searchTerm) throws BestResultNotFound {

        int maxMatchesFounded = 0;
        Searchable bestResult = null;
        String tempString;

        for (Searchable found : searchTerms) {

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