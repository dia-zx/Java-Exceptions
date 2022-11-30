package Lesson2.Task1;

import java.util.Scanner;

/*
 * Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
 * и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения,
 *  вместо этого, необходимо повторно запросить у пользователя ввод данных.
 */
public class main {
    public static void main(String[] args) {
        System.out.println("Введите дробное число (float)");
        method();
    }

    public static float method() {
        float res;
        do {
            Scanner scanner = new Scanner(System.in);
            try {
                res = scanner.nextFloat();
            } catch (Exception e) {
                continue;
            }
            scanner.close();
            return res;
        } while (true);
    }
}
