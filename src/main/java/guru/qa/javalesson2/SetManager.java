package guru.qa.javalesson2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetManager<T> {
    private final Set<T> set = new HashSet<>();

    public void addElement(T element) {
        set.add(element);
        System.out.println("Добавлено: " + element);
    }

    public boolean searchElement(T element) {
        Iterator<T> iterator = set.iterator();
        while (iterator.hasNext()) {  // Используем цикл while
            if (iterator.next().equals(element)) {
                return true;
            }
        }
        return false;
    }

    public void removeElement(T element) {
        set.remove(element);
        System.out.println("Удалено: " + element);
    }

    public void display() {
        System.out.println("Множество: " + set);
    }
}

