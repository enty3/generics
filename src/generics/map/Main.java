package generics.map;

import generics.DataUtils;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> doubledNumbers = map(DataUtils.getRandomNumbers(), num -> num * 2);
        System.out.println("Dvojnásobky čísel: " + doubledNumbers);
        List<Integer> lengths = map(DataUtils.getRandomStrings(), String::length);
        System.out.println("Délky všech řetězců: " + lengths);
    }

    public static <T, R> List<R> map(List<T> list, Map<T, R> fn) {
        List<R> result = new ArrayList<>();
        for (T item : list) {
            R mappedItem = fn.apply(item);
            result.add(mappedItem);
        }
        return result;
    }
}
interface Map<T, R> {
    R apply(T item);
}


