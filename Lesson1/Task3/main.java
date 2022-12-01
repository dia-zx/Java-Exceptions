package Lesson1.Task3;

/*
 * Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
 *  и возвращающий новый массив, каждый элемент которого равен частному элементов двух входящих массивов в той же ячейке.
 *  Если длины массивов не равны, необходимо как-то оповестить пользователя.
 *  Важно: При выполнении метода единственное исключение, которое пользователь может увидеть - RuntimeException, т.е. ваше. 
 */
public class main {
    public static void main(String[] args) {
        int[] mas1 = new int[] { 1, 2, 3, 4, 5, 6 };
        int[] mas2 = new int[] { 5, 1, 2, 3, 4, 5, 6 };
        int[] mas3 = new int[] { 5, 4, 3, 2, 1, 0 };

        try {
            method(mas1, mas2); // будет вызвано исключение (длины массивов различны)
            method(mas1, mas3); // будет вызвано исключение (элемент массива == 0) если закомментировать строку
                                // выше.
        } catch (RuntimeException e) {
            System.out.println("произошло исключение: " + e);
        }
    }

    public static int[] method(int[] mas1, int[] mas2) {
        if (mas1.length != mas2.length)
            throw new RuntimeException("Длины массивов различны!");
        int[] res = new int[mas1.length];
        for (int i = 0; i < mas1.length; i++) {
            if (mas2[i] == 0)
                throw new RuntimeException("Элемент mas2[" + i + "] == 0!");
            res[i] = mas1[i] / mas2[i];
        }
        return res;
    }
}
