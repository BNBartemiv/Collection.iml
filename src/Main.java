import Array.ArraylistHW;

import java.util.Arrays;

public class Main {
    public static void main(String[] args){

        ArraylistHW<Integer> Hello = new ArraylistHW<>();

        Hello.add(10);
        Hello.add(5);
        Hello.add(20);
        Hello.add(15);
        Hello.add(1);

        System.out.println("Массив: " + Hello);
        System.out.println("Элемент на 3 позиции: " + Hello.get(2));

        Hello.remove(2);
        System.out.println("Массив с удаленным элементом на 3 позиции: " + Hello);

        Hello.addAll(Arrays.asList(30, 50, 70));
        System.out.println("Массив с добавленными доп. числами: " + Hello);

        System.out.println("До сортировки: " + Hello);

        Hello.sort();

        System.out.println("После сортировки: " + Hello);


    }
}
