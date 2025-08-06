package org.skypro.skyshop.tools;

public class Comparator implements java.util.Comparator<Searchable> {

    @Override
    public int compare(Searchable sObj1, Searchable sObj2) {
        int lengths = Integer.compare(sObj2.getName().length(), sObj1.getName().length());
        if (lengths == 0) {
            return sObj1.getName().compareTo(sObj2.getName());
        } else {
            return lengths;
        }
    }
}
