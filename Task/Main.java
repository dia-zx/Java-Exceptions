package Task;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
 * Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке, разделенные пробелом:
 * Фамилия Имя Отчество датарождения номертелефона пол
 * Форматы данных:
 *       фамилия, имя, отчество - строки
 *   -дата_рождения - строка формата dd.mm.yyyy
 *   -номер_телефона - целое беззнаковое число без форматирования
 *   -пол - символ латиницей f или m.
 *Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым, вернуть код ошибки, обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.
 *
 *Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры. Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы. Можно использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.
 *
 *Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку должны записаться полученные данные, вида:
 *  <Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>
 * Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
 *
 *Не забудьте закрыть соединение с файлом.
 *
 *При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, пользователь должен увидеть стектрейс ошибки.
 */
public class Main {
    public static void main(String[] args) {
        //#region создание каталога для архива...
        String path = "persons";
        File f = new File(path);
        try {
            f.mkdir();
        } catch (Exception e) {
            System.out.println("Внимание! Ошибка создания каталога! " + e.getMessage());
            e.printStackTrace();
            return;
        }
        //#endregion

        save_persons(user_input(), path + "\\");
    }

    /**
     * Диалог с пользователем и наполнение словаря - коллекции персон.
     * @return словарь - коллекция персон
     */
    public static Map<String, List<Person>> user_input() {
        Map<String, List<Person>> result;
        result = new HashMap();
        Scanner scanner = new Scanner(System.in, "866");
        do {
            System.out.println("\nВведите данные пользователя, разделенные пробелом в произвольном порядке");
            System.out.println("Пустая строка - завершение");
            System.out.println("Фамилия Имя Отчество | дата рождения(dd.mm.yyyy) | номер телефона | пол (f, m):");
            String input = scanner.nextLine();
            if (input.equals(""))
                break;
            try {
                Person person = Person.parce(input);
                System.out.println("-----:" + input);
                System.out.println("-----:" + person.toString());
                if (result.containsKey(person.second_name)) {
                    result.get(person.second_name).add(person);
                } else {
                    result.put(person.second_name, new ArrayList<Person>());
                    result.get(person.second_name).add(person);
                }
            } catch (Exception ex) {
                System.out.println("Внимание! " + ex.getMessage());
            }
        } while (true);
        scanner.close();
        return result;
    }

    /**
     * Запись в каталог персон в файлах с именем = Фамилии
     * @param map коллекция (словарь) персон
     * @param dir_path путь до каталога в котором будут размешены файлы персон
     */
    public static void save_persons(Map<String, List<Person>> map, String dir_path) {
        for (List<Person> persons : map.values()) {
            System.out.println("Запись в файл:" + persons.get(0).second_name);
            File f = new File(dir_path + "\\" + persons.get(0).second_name);
            FileWriter fileWriter = null;
            try {
                f.createNewFile();
                fileWriter = new FileWriter(f, false);
                for (Person person : persons) {
                    System.out.println("Запись в файл:" + person.toString() + '\n');
                    fileWriter.write(person.toString() + '\n');
                
                }
                fileWriter.flush();
            } catch (Exception e) {
                System.out.println("Внимание! " + e.getMessage());
                e.printStackTrace();
            }
            finally {
                try {
                    fileWriter.close();
                } catch (Exception e) {
                    System.out.println("Внимание! " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }
}
