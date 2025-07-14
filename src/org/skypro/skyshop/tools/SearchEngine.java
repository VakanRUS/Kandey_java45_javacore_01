
package org.skypro.skyshop.tools;

import org.skypro.skyshop.Exceptions.BestResultNotFound;
import org.skypro.skyshop.product.Product;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

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

    public List<Searchable> search(String searchTerm) {
        List<Searchable> founded = new LinkedList<>();
        Iterator<Searchable> iterator = search.iterator();
        Searchable searchItem;
        while (iterator.hasNext()) {
            searchItem = iterator.next();
            if (searchItem.getSearchTerm().toLowerCase().contains(searchTerm.toLowerCase())) {
                founded.add(searchItem);
                iterator.remove();
            }
        }
        if (founded.isEmpty()) {
            System.out.println("Продукт не найден\n" + founded + "\n");
        }
        return founded;
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