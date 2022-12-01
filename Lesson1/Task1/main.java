package Lesson1.Task1;

import java.util.List;

/**
 * Реализуйте 3 метода, чтобы в каждом из них получить разные исключения
 * Посмотрите на код, и подумайте сколько разных типов исключений вы тут сможете
 * получить?
 */
public class main {
    public static void main(String[] args) {
        method1(); // ArithmeticException
        method2(); // ArrayIndexOutOfBoundsException
        method3(); // NullPointerException

        /*
         * Каждый из методов вызывает свой тип исключений ArithmeticException,
         * ArrayIndexOutOfBoundsException, NullPointerException.
         * при получении первого исключения в одном из методов выполнение программы
         * прекращается, т.о.
         * чтобы увидеть все исключения, генерируемые методами нужно последовательно
         * комментировать вызовы этих 3х методов.
         */
    }

    public static void method1() {
        System.out.println(5 / 0); // ArithmeticException
    }

    public static void method2() {
        int[] mas = new int[10];
        System.out.println(mas[11]); // ArrayIndexOutOfBoundsException
    }

    public static void method3() {
        List list = null;
        System.out.println(list.size()); // NullPointerException
    }

}