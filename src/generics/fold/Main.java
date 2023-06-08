package generics.fold;

import generics.filter.DataUtils;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // TODO nejkratší délka řetězce
        // TODO součet délek stringů

    // TODO fold metoda, která převede list jednoho typu na hodnotu druhého typu, do metody také předáváme defaultní hodnotu druhého typu
    //  každou hodnotu a mezivýsledek tedy převede na hodnotu druhého typu
    //  oba typy můžou být stejné, to ničemu nevadí

    ArrayList<String> data = DataUtils.getRandomStrings();
    int shortestlenght= fold(data,Integer.MAX_VALUE,(str,len) -> {
        if(str.length() < len){
            return str.length();
        }else {
            return len;
        }

    });
        System.out.println(shortestlenght);
        int finalsum=fold(DataUtils.getRandomNumbers(),0, (i, sum) -> i + sum );
            System.out.println(finalsum);
    }

    public static <T,R> R fold(ArrayList<T> values,R initialValue, FoldFuncition<T,R> fn){
       R result= initialValue;
        for (T value : values) {
            result= fn.invoke(value,result);
        }
       return result;
    }


    public static int sum(ArrayList<Integer> cisla){
        int sum=0;
        for (Integer integer : cisla) {
            sum= sum + integer;
        }
        return sum;
    }

}


interface FoldFuncition<T,R>{

    R invoke(T t, R r);
}
