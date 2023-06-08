package generics.filter;


import java.util.ArrayList;
import java.util.concurrent.locks.Condition;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> data = DataUtils.getRandomStrings();
        System.out.println(filter(data,(s) -> {
            System.out.println(s);
            return s.startsWith("M");
        }));
        // TODO vypsat stringy začínající na M
        // TODO vypsat čísla větší než 100
        ArrayList<Integer> Datas = DataUtils.getRandomNumbers();
        System.out.println(filter(Datas,(c) -> {
            System.out.println("hodnota: " + c);
            return c > 100;
        } ));
    }
    @FunctionalInterface
    interface Condition<T> {
        boolean isValid(T e);
    }


    public static <T> ArrayList<T> filter(ArrayList<T> list, Condition<T> predicate) {
        ArrayList<T> result = new ArrayList<>();
        for (T e : list) {
            if (predicate.isValid(e)) {
                result.add(e);
            }
        }
        return result;
    }

}
