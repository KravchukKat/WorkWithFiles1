package guru.qa.javalesson2;

public class CollectionTest {
    public static void main(String[] args) {
        System.out.println("=== Работа с List ===");
        ListManager<String> listManager = new ListManager<>();
        listManager.addElement("Apple");
        listManager.addElement("Banana");
        listManager.display();
        System.out.println("Поиск Apple: " + listManager.searchElement("Apple"));
        listManager.removeElement("Banana");
        listManager.display();

        System.out.println("\n=== Работа с Set ===");
        SetManager<Integer> setManager = new SetManager<>();
        setManager.addElement(10);
        setManager.addElement(20);
        setManager.display();
        System.out.println("Поиск 10: " + setManager.searchElement(10));
        setManager.removeElement(10);
        setManager.display();

        System.out.println("\n=== Работа с LinkedList ===");
        LinkedListManager<String> linkedListManager = new LinkedListManager<>();
        linkedListManager.addElement("Dog");
        linkedListManager.addElement("Cat");
        linkedListManager.display();
        System.out.println("Поиск Cat: " + linkedListManager.searchElement("Cat"));
        linkedListManager.removeElement("Dog");
        linkedListManager.display();

        System.out.println("\n=== Работа с Map ===");
        MapManager<String, Integer> mapManager = new MapManager<>();
        mapManager.addElement("One", 1);
        mapManager.addElement("Two", 2);
        mapManager.display();
        System.out.println("Поиск ключа 'One': " + mapManager.searchElement("One"));
        mapManager.removeElement("One");
        mapManager.display();
    }
}
