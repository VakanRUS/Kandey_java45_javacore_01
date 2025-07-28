package org.skypro.skyshop.tools;

import org.skypro.skyshop.Exceptions.BestResultNotFound;
import org.skypro.skyshop.product.Product;

import java.util.*;

public class SearchEngine {

    private Set<Searchable> search;

    public SearchEngine() {
        search = new HashSet<>();
    }

    public void addSearchable(Searchable searchTerm) {
        search.add(searchTerm);
    }

    public Set<Searchable> search(String searchTerm) {
        if (searchTerm == null) {
            System.out.println("Отправлен пустой запрос, поиск невозможен");
            return null;
        } else {
            Set<Searchable> foundElements = new TreeSet<>(new Comparator());
            for (Searchable searchableElement : search) {
                if (searchableElement != null && searchableElement.getSearchTerm().toLowerCase().contains(searchTerm.toLowerCase())) {
                    foundElements.add(searchableElement);
                }
            }
            return foundElements;
        }
    }

    public Searchable searchBestResult(String searchTerm) throws BestResultNotFound {

        int maxMatchesFounded = 0;
        Searchable bestResult = null;
        String tempString;

        for (Searchable found : search) {

            if (found != null) {
                tempString = found.getSearchTerm().toLowerCase();
                int counter = 0;
                int index;
                int indexOfFoundedMatch = tempString.indexOf(searchTerm.toLowerCase(), 0);
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

    @Override
    public String toString() {
        return "SearchEngine{" +
                "searchableElements=" + search +
                '}';
    }
}