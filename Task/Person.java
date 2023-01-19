package Task;

public class Person {
    public String second_name;
    public String name;
    public String patronymic;
    public String birthday;
    public String phone;
    public String gender;

    public static Person parce(String str) throws Exception {
        String[] lines = str.split("\\s+");

        if (lines.length != 6)
            throw new IllegalArgumentException("Неверное число данных пользователя (6)");

        Person person = new Person();
        for (String string : lines) {
            if (string.equals('m') || string.equals('f')) {
                if (person.gender == null) {
                    person.gender = string;
                    continue;
                } else
                    throw new IllegalArgumentException("Пол указан 2 раза!");
            }

            if (string.contains(".")) {
                check_birthday(string);
                if (person.birthday == null) {
                    person.birthday = string;
                    continue;
                } else
                    throw new IllegalArgumentException("Дата рождения указана 2 раза!");
            }

            boolean is_phone = false;
            for (int i = 0; i < string.length(); i++) {
                if (string.charAt(i) < '0' || string.charAt(i) > '9')
                    continue;
                try {
                    Long.parseLong(string);
                } catch (Exception ex) {
                    throw new IllegalArgumentException("Неверный формат номера телефона!");
                }
                if (person.phone == null) {
                    person.phone = string;
                    is_phone = true;
                    break;
                } else
                    throw new IllegalArgumentException("Номер телефона указан 2 раза!");
            }
            if (is_phone)
                continue;
            
            if (person.second_name == null) {
                person.second_name = string;
                continue;
            }
            if (person.name == null) {
                person.name = string;
                continue;
            }
            if (person.patronymic == null) {
                person.patronymic = string;
                continue;
            }            
        }

        return person;
    }

    /**
     * Проверка формата Даты рождения dd.mm.yyyy
     * 
     * @param str проверяемая строка
     * @throws Exception при неверном формате
     */
    private static void check_birthday(String str) throws Exception {
        String[] date_numbers = str.split("\\.");
        if (date_numbers.length != 3)
            throw new IllegalArgumentException("Неверный формат даты рождения");
        if ((date_numbers[0].length() != 2) || (date_numbers[1].length() != 2) || (date_numbers[2].length() != 4))
            throw new IllegalArgumentException("Неверный формат даты рождения");
        for (String number : date_numbers) {
            try {
                Integer.parseInt(number);
            } catch (Exception ex) {
                throw new IllegalArgumentException("Неверный формат даты рождения");
            }
        }
        return;
    }

}
