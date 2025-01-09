import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Animals> beast = new ArrayList<>();
        Registration beastregistry = new Registration();
        Counter counter = new Counter();

        boolean start = true;

        beast.add(new Cat("Senya", LocalDate.of(2011, 1, 1), "Animals.Cat", "lie"));
        beast.add(new Cat("Marta", LocalDate.of(2017, 1, 1), "Animals.Cat", "run"));
        beast.add(new Dog("Jack", LocalDate.of(2020, 1, 1), "Animals.Dog", "Can give a paw"));
        beast.add(new Hamster("Homa", LocalDate.of(2022, 10, 12), "Animals.Hamster", null));
        beast.add(new Horse("Grom", LocalDate.of(2020, 1, 12), "Animals.Horse", "run, step"));
        beast.add(new Horse("Skoryi", LocalDate.of(2020, 11, 10), "Animals.Horse", "run, step, gallop"));
        beast.add(new Camel("Gorbatyi", LocalDate.of(2022, 4, 10), "Animals.Camel", "bend over"));
        beast.add(new Donkey("Tosha", LocalDate.of(2020, 3, 12), "Animals.Donkey", null));

        for (Animals animal : beast) {
            beastregistry.addAnimal(animal);
        }

        while (start) {
            System.out.println();
            System.out.println("Вы вошли в реестр животных!\n\nЧто вам необходимо?");
            System.out.println("\n1. Вывести список животных.\n2. Выбрать животное.");
            System.out.println("3. Добавить новое животное.\n4. Обучить животное новой комманде.");
            System.out.println("5. Выход.");
            System.out.println("\nВыбрать пункт:");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    beastregistry.listAnimals();
                    break;
                case 2:
                    System.out.println("Введите имя животного: ");
                    String name = scanner.nextLine().trim();
                    Animals animal = beastregistry.getAnimal(name);
                    if (animal != null) {
                        System.out.println(animal);
                    }else{
                        System.out.println("Животное не найдено.");
                    }
                    break;
                case 3:
                    try {
                        System.out.println("Введите имя животного: ");
                        String newName = scanner.nextLine();
                        System.out.println("Введите дату рождения в следующем порядке-> год-месяц-день: ");
                        String newBirth = scanner.nextLine();
                        LocalDate birth = LocalDate.parse(newBirth);
                        System.out.println("Что это за животное? ");
                        String newType = scanner.nextLine().toLowerCase();
                        System.out.println("Какие команды знакомы животному? ");
                        String newCommand = scanner.nextLine();

                        if (newName.isEmpty() || birth == null || newType.isEmpty()) {
                            System.out.println("Пожалуйста, заполните все поля!");
                            continue;
                        }

                        Animals newAnimal;

                        if (newType.equals("cat") || newType.equals("dog") || newType.equals("hamster")) {
                            newAnimal = new Home_animals(newName, birth, newType, newCommand);
                        } else if (newType.equals("horse") || newType.equals("camel") || newType.equals("donkey")) {
                            newAnimal = new Pack_animals(newName, birth, newType, newCommand);
                        } else {
                            newAnimal = new Animals(newName, birth, newType, newCommand);
                        }

                        beastregistry.addAnimal(newAnimal);
                        counter.add();
                        System.out.println("Кол-во заведенных животных: " + counter.toString());

                    } catch (Exception e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Введите имя животного: ");
                    String animalName = scanner.nextLine();
                    Animals selectedAnimal = beastregistry.getAnimal(animalName);
                    if (selectedAnimal != null) {
                        System.out.println("Введите новую команду/команды: ");
                        String newCommands = scanner.nextLine();
                        selectedAnimal.addCommands(newCommands);
                        System.out.println("Команда/команды добавлены.");;
                    }else{
                        System.out.println("Животное не найдено.");
                    }
                    break;
                case 5:
                    start = false;
                    break;
                default:
                    System.out.println("Неоходимо выбрать цифру от 1 до 5.");
            }
        }
        scanner.close();
        counter.close();
        System.out.println("До свидания!");
    }
}
