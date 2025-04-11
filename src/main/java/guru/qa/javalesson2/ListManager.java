package guru.qa.javalesson2;

import java.util.ArrayList;
import java.util.List;

public class ListManager<T> {
    private final List<T> list = new ArrayList<>();

    public void addElement(T element) {
        list.add(element);
        System.out.println("Добавлено: " + element);
    }

    public boolean searchElement(T element) {
        for (int i = 0; i < list.size(); i++) {  // Используем цикл for
            if (list.get(i).equals(element)) {
                return true;
            }
        }
        return false;
    }

    public void removeElement(T element) {
        list.remove(element);
        System.out.println("Удалено: " + element);
    }

    public void display() {
        System.out.println("Список: " + list);
    }
}
