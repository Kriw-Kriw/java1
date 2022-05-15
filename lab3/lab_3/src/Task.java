import java.util.ArrayList;
import java.util.Collections;


public class Task {
    public static void main(String args[]) throws Exception {

        List list = new List();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);

        System.out.print("Изначальная версия списка: ");
        list.print();
        System.out.print("\n---------------------------------\n");

        int new_elem = 5;
        System.out.print("Добавление " + new_elem +  " в список: ");
        list.add(new_elem);
        list.print();
        System.out.print("\n---------------------------------\n");

        System.out.print("Поиск первого вхождения " + new_elem +  " в списке: ");
        System.out.print(list.indexOf(new_elem));
        System.out.print("\n---------------------------------\n");

        System.out.print("Поиск последнего вхождения " + new_elem +  " в списке: ");
        System.out.print(list.lastindexOf(new_elem));
        System.out.print("\n---------------------------------\n");

        int index = 3;
        System.out.print("Изменение значения элемента с индексом, " + index + " с " + list.get(index) + " на " + new_elem + " в списке: " );
        list.set(index, new_elem);
        list.print();
        System.out.print("\n---------------------------------\n");

        int strat = 2, end = 6;
        System.out.print("Выделение подмножества со " + strat + " по " + end + " элементы в списке: ");
        list.subList(strat, end).print();
        System.out.print("\n---------------------------------\n");


        int remove_index = 3;
        System.out.print("Удаление элемента " + remove_index + " из списка: ");
        list.remove(remove_index);
        list.print();
        System.out.print("\n---------------------------------\n");


    }
}
