package generics.reduce;

import generics.filter.DataUtils;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // TODO součin všech čísel
        int soucin = reduce(DataUtils.getRandomNumbers(), (a, b) -> a * b);
        System.out.println("Součin všech čísel: " + soucin);
        // TODO spojení všech řetězců
        ArrayList<String> strings = DataUtils.getRandomStrings();
        String retezec = reduce(strings, (a, b) -> a + b);
        System.out.println("Spojení všech řetězců: " + retezec);
    }


    // TODO reduce metoda, která z listu jednoho typu udělá jednu hodnotu toho samého typu
    //  každou hodnotu a mezivýsledek tedy převede na jednu hodnotu
    //  pokud je list prázdný, vyhodí výjimku
    public static <T> T reduce(ArrayList<T> values, Reduce<T> fn) {
        if (values.isEmpty()) {
            throw new IllegalArgumentException("List is empty.");
        }
        T acc = values.get(0);
        for (int i = 1; i < values.size(); i++) {
            T value = values.get(i);
            acc = fn.invoke(value, acc);
        }
        return acc;
    }

}

interface Reduce<T> {
    T invoke(T value, T acc);
}
