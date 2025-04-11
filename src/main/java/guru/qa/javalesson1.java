package guru.qa;

public class javalesson1 {

    public static void main(String[] args) {
        int a = 100;
        int b = 57;
        int d = 120;
        double c = 0.5;

        // 0) применить несколько арифметических операций ( + , -, * , /) над двумя примитивами типа int
        int sum = a + b;
        int difference = a - b;
        int product = a * b;
        int quotient = a / b;

        System.out.println("Сумма: " + sum);
        System.out.println("Разность: " + difference);
        System.out.println("Произведение: " + product);
        System.out.println("Частное: " + quotient);

        // 1) применить несколько арифметических операций над int и double в одном выражении
        double result = (d*c-b+a)/b;
        System.out.println("Результат: " + result);

        //2) применить несколько логических операций ( < , >, >=, <= )
        boolean condition1 = (a > b) && (d >= a);  // true && true → true
        boolean condition2 = (d < a) || (a <= b);  // false || false → false
        boolean condition3 = !(a == d);            // !(false) → true

        System.out.println("(a > b) && (d >= a): " + condition1);
        System.out.println("(d < a) || (a <= b): " + condition2);
        System.out.println("!(a == d): " + condition3);

        //4) получить переполнение при арифметической операции
        float bigFloat = Float.MAX_VALUE * 10; // Переполнение
        double bigDouble = Double.MAX_VALUE * 10; // Переполнение
        float smallFloat = Float.MIN_VALUE / 1000000;
        double smallDouble = Double.MIN_VALUE / 1000000;

        System.out.println("Переполненный float: " + bigFloat);
        System.out.println("Переполненный double: " + bigDouble);
        System.out.println("Слишком маленький float: " + smallFloat);
        System.out.println("Слишком маленький double: " + smallDouble);
    }

}
