package Lesson2.Task4;

import java.util.Scanner;

/*
 * Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
 * Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
 */
public class main {
    public static void main(String[] args) {
        System.out.println("Введите строку текста (пустые строки вводить нельзя!).");
        try {
            text_input();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static String text_input() throws RuntimeException {
        Scanner scanner = new Scanner(System.in);

        String res = scanner.nextLine();
        scanner.close();
        if (res.equals("")) {
            throw new RuntimeException("Путые строки вводить нельзя!");
        }
        return res;
    }
}
