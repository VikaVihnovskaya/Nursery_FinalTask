package com.vicky;

import com.vicky.exception.AnimalsNotFoundException;
import com.vicky.exception.AnimalsWithSameNameExistedException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Controller {

    private final AnimalService animalService;
    private final Scanner scanner;


    public Controller() {
        this.animalService = new DefaultAnimalService();
        this.scanner = new Scanner(System.in);
    }

    public void redactor() {

            while (true) {
                try(Counter counter = new Counter()) {
                    System.out.println("Меню:");
                    System.out.println("1. Добавить новое животное");
                    System.out.println("2. Просмотреть список команд животного");
                    System.out.println("3. Обучить животное новой команде");
                    System.out.println("0. Выход");
                    System.out.print("Выберите пункт меню: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine();

                    switch (choice) {
                        case 1:
                            addAnimls();
                            counter.increment();
                            break;

                        case 2: {
                            System.out.println("Введите имя животного:");
                            String name = scanner.nextLine();
                            String commands = animalService.getCommands(name);
                            System.out.println("Комманды: " + commands);
                            break;
                        }
                        case 3: {
                            System.out.println("Введите имя животного:");
                            String name = scanner.nextLine();
                            System.out.println("Введите новые команды через запятую:");
                            String commands = scanner.nextLine();
                            animalService.learnNewCommands(name, commands);
                            break;
                        }
                        case 0: {
                            System.out.println("Программа завершена.");
                            return;
                        }
                        default:
                            System.out.println("Неверный выбор. Попробуйте снова.");
                            break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Неверный формат ввода. Попробуйте снова.");
                    scanner.nextLine();
                } catch (AnimalsNotFoundException | AnimalsWithSameNameExistedException e) {
                    System.out.println(e.getMessage() + ". Попробуйте снова.");
                    scanner.nextLine();
                } catch (Exception e) {
                    System.out.println("Возникла ошибка. Попробуйте снова.");
                    scanner.nextLine();
                }
            }
    }

    private void addAnimls() {
        System.out.println("Введите имя животного:");
        String name = scanner.nextLine();
        System.out.println("Введите список команд через запятую:");
        String commands = scanner.nextLine();

        System.out.println("Выберите класс животного:");
        System.out.println("1. Кошка");
        System.out.println("2. Собака");
        System.out.println("3. Хомяк");
        System.out.println("4. Осёл");
        System.out.println("5. Конь");
        System.out.println("6. Верблюд");
        int animalClass = scanner.nextInt();
        AnimalType animalType = null;
        switch (animalClass) {
            case 1:
                animalType = AnimalType.CAT;
                break;
            case 2:
                animalType = AnimalType.DOG;
                break;
            case 3:
                animalType = AnimalType.HAMSTER;
                break;
            case 4:
                animalType = AnimalType.DONKEY;
                break;
            case 5:
                animalType = AnimalType.HORSE;
                break;
            case 6:
                animalType = AnimalType.CAMEL;
                break;
            default: {
                System.out.println("Неверный класс животного.");
                break;
            }
        }
        animalService.create(name, commands, animalType);
    }
}