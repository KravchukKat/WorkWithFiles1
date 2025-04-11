package guru.qa.javalesson2;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedListManager<T> {
    private final List<T> linkedList = new LinkedList<>();

    public void addElement(T element) {
        linkedList.add(element);
        System.out.println("Добавлено: " + element);
    }

    public boolean searchElement(T element) {
        ListIterator<T> iterator = linkedList.listIterator();
        boolean found = false;
        do {  // Используем цикл do-while
            if (iterator.hasNext() && iterator.next().equals(element)) {
                found = true;
                break;
            }
        } while (iterator.hasNext());
        return found;
    }

    public void removeElement(T element) {
        linkedList.remove(element);
        System.out.println("Удалено: " + element);
    }

    public void display() {
        System.out.println("Связанный список: " + linkedList);
    }
}
