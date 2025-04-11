package guru.qa.javalesson2;

import java.util.HashMap;
import java.util.Map;

public class MapManager<K, V> {
    private final Map<K, V> map = new HashMap<>();

    public void addElement(K key, V value) {
        map.put(key, value);
        System.out.println("Добавлено: " + key + " -> " + value);
    }

    public boolean searchElement(K key) {
        for (Map.Entry<K, V> entry : map.entrySet()) {  // Используем цикл foreach
            if (entry.getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    public void removeElement(K key) {
        map.remove(key);
        System.out.println("Удалено: " + key);
    }

    public void display() {
        System.out.println("Словарь: " + map);
    }
}

