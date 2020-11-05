package com.company;
import java.sql.*;
import java.util.Scanner;

public class View {
    void run(Controller controller, Scanner scanner) {
        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1.Добавление/редактирование/удаление информации об объектах города.");
            System.out.println("2.Добавление/редактирование/удаление информации о владельцах.");
            System.out.println("3.Добавление/редактирование/удаление информации о популярности объектов.");
            System.out.println("4.Добавление/редактирование/удаление информации о мероприятиях.");
            System.out.println("5.Просмотр списка объектов города на текущую дату –дата, название действующих объектов – тип, название, адрес.");
            System.out.println("6.Просмотр списка мероприятий, которые будут проводится в ближайшие 2 недели – дата проведения, название мероприятия, название объекта, адрес..");
            System.out.println("7.Просмотр списка объектов заданного типа на текущую дату..");
            String answer = scanner.nextLine();

            switch (answer) {
                case "1": {
                    System.out.println("Выберите действие:");
                    System.out.println("1.Добавление информации об объектах города.");
                    System.out.println("2.Редактирование информации об объектах города.");
                    System.out.println("3.Удаление информаации об объектах города.");
                    String inventory_answer = scanner.nextLine();
                    switch (inventory_answer) {
                        case "1": {
                            System.out.println("Введите тип объекта");
                            String objectType = scanner.nextLine();
                            System.out.println("Введите адресс объекта");
                            String objectAdress = scanner.nextLine();
                            System.out.println("Введите имя объекта");
                            String objectName = scanner.nextLine();
                            System.out.println("Введите ФИО владельца объекта");
                            String objectOwner = scanner.nextLine();
                            System.out.println("Введите телефон объекта");
                            String objectPhone = scanner.nextLine();
                            System.out.println("Введите дату открытия объекта");
                            String objectOpenDate = scanner.nextLine();
                            System.out.println("Введите дату открытия закрытия");
                            String objectCloseDate = scanner.nextLine();
                            controller.addingCityObject(objectType, objectAdress, objectName, objectOwner, objectPhone, Date.valueOf(objectOpenDate), Date.valueOf(objectCloseDate));
                            break;
                        }
                        case "2": {
                            System.out.println("Введите тип объекта");
                            String objectType = scanner.nextLine();
                            System.out.println("Введите адресс объекта");
                            String objectAdress = scanner.nextLine();
                            System.out.println("Введите имя объекта");
                            String objectName = scanner.nextLine();
                            System.out.println("Введите ФИО владельца объекта");
                            String objectOwner = scanner.nextLine();
                            System.out.println("Введите новый тип объекта");
                            String newObjectType = scanner.nextLine();
                            System.out.println("Введите новый адресс объекта");
                            String newObjectAdress = scanner.nextLine();
                            System.out.println("Введите новое имя объекта");
                            String newObjectName = scanner.nextLine();
                            System.out.println("Введите новое ФИО владельца объекта");
                            String newObjectOwner = scanner.nextLine();
                            System.out.println("Введите новый телефон объекта");
                            String newObjectPhone = scanner.nextLine();
                            System.out.println("Введите новою дату открытия объекта");
                            String newObjectOpenDate = scanner.nextLine();
                            System.out.println("Выберите новый сезон работы объекта \n 1-лето 2-зима 3-все");
                            String newObjectCloseDate = scanner.nextLine();
                            controller.updatingCityObject(objectType, objectAdress, objectName, objectOwner, newObjectType, newObjectAdress, newObjectName, newObjectOwner, newObjectPhone, Date.valueOf(newObjectOpenDate), Date.valueOf(newObjectCloseDate));
                            break;
                        }
                        case "3": {
                            System.out.println("Введите тип объекта");
                            String objectType = scanner.nextLine();
                            System.out.println("Введите адресс объекта");
                            String objectAdress = scanner.nextLine();
                            System.out.println("Введите имя объекта");
                            String objectName = scanner.nextLine();
                            System.out.println("Введите ФИО владельца объекта");
                            String objectOwner = scanner.nextLine();
                            controller.deletingCityObject(objectType, objectAdress, objectName, objectOwner);
                            break;
                        }
                    }
                    break;
                }
                case "2": {
                    System.out.println("Выберите действие:");
                    System.out.println("1.Добавление информации о владельцах.");
                    System.out.println("2.Редактирование информации о владельцах.");
                    System.out.println("3.Удаление информаации о владельцах.");
                    String storageAnswer = scanner.nextLine();
                    switch (storageAnswer) {
                        case "1": {
                            System.out.println("Выберите тип владельца \n 1-частное 2-юридическое");
                            String ownerType = scanner.nextLine();
                            System.out.println("Введите ФИО владельца");
                            String ownerInfo = scanner.nextLine();
                            System.out.println("Введите имя объекта");
                            String objectName = scanner.nextLine();
                            controller.addingOwners(Integer.parseInt(ownerType), ownerInfo, objectName);
                            break;
                        }
                        case "2": {
                            System.out.println("Выберите тип владельца \n 1-частное 2-юридическое");
                            String ownerType = scanner.nextLine();
                            System.out.println("Введите ФИО владельца");
                            String ownerInfo = scanner.nextLine();
                            System.out.println("Введите имя объекта");
                            String objectName = scanner.nextLine();
                            System.out.println("Выберите новый тип владельца \n 1-частное 2-юридическое");
                            String newOwnerType = scanner.nextLine();
                            System.out.println("Введите новое ФИО владельца");
                            String newOwnerInfo = scanner.nextLine();
                            System.out.println("Введите новое имя объекта");
                            String newObjectName = scanner.nextLine();
                            controller.updatingOwners(Integer.parseInt(ownerType), ownerInfo, objectName, Integer.parseInt(newOwnerType), newOwnerInfo, newObjectName);
                            break;
                        }
                        case "3": {
                            System.out.println("Выберите тип владельца \n 1-частное 2-юридическое");
                            String ownerType = scanner.nextLine();
                            System.out.println("Введите ФИО владельца");
                            String ownerInfo = scanner.nextLine();
                            System.out.println("Введите имя объекта");
                            String objectName = scanner.nextLine();
                            controller.deletingOwners(Integer.parseInt(ownerType), ownerInfo, objectName);
                            break;
                        }
                    }
                    break;
                }
                case "3": {
                    System.out.println("Выберите действие:");
                    System.out.println("1.Добавление информации о популярности объектов.");
                    System.out.println("2.Редактирование информации о популярности объектов.");
                    System.out.println("3.Удаление информаации о популярности объектов.");
                    String inventory_answer = scanner.nextLine();
                    switch (inventory_answer) {
                        case "1": {
                            System.out.println("Введите дату последнего сбора информации");
                            String populartyDate = scanner.nextLine();
                            System.out.println("Введите количество посетителей");
                            String visits = scanner.nextLine();
                            System.out.println("Введите имя объекта");
                            String objectName = scanner.nextLine();
                            controller.addingPopularty(Date.valueOf(populartyDate), Integer.parseInt(visits), objectName);
                            break;
                        }
                        case "2": {
                            System.out.println("Введите дату последнего сбора информации");
                            String populartyDate = scanner.nextLine();
                            System.out.println("Введите количество посетителей");
                            String visits = scanner.nextLine();
                            System.out.println("Введите имя объекта");
                            String objectName = scanner.nextLine();
                            System.out.println("Введите новою дату последнего сбора информации");
                            String newPopulartyDate = scanner.nextLine();
                            System.out.println("Введите новое количество посетителей");
                            String newVisits = scanner.nextLine();
                            System.out.println("Введите новое имя объекта");
                            String newObjectName = scanner.nextLine();
                            controller.updatingPopularty(Date.valueOf(populartyDate), Integer.parseInt(visits), objectName, Date.valueOf(newPopulartyDate), Integer.parseInt(newVisits), newObjectName);
                            break;
                        }
                        case "3": {
                            System.out.println("Введите дату последнего сбора информации");
                            String populartyDate = scanner.nextLine();
                            System.out.println("Введите количество посетителей");
                            String visits = scanner.nextLine();
                            System.out.println("Введите имя объекта");
                            String objectName = scanner.nextLine();
                            controller.deletingPopularty(Date.valueOf(populartyDate), Integer.parseInt(visits), objectName);
                            break;
                        }
                    }
                    break;
                }
                case "4": {
                    System.out.println("Выберите действие:");
                    System.out.println("1.Добавление информации о мероприятиях.");
                    System.out.println("2.Редактирование информации о мероприятиях.");
                    System.out.println("3.Удаление информаации о мероприятиях.");
                    String inventory_answer = scanner.nextLine();
                    switch (inventory_answer) {
                        case "1": {
                            System.out.println("Введите имя объекта");
                            String objectName = scanner.nextLine();
                            System.out.println("Введите дату проведения мероприятия");
                            String inventDate = scanner.nextLine();
                            System.out.println("Введите имя мероприятия");
                            String inventName = scanner.nextLine();
                            System.out.println("Введите тип мероприятия");
                            String inventType = scanner.nextLine();
                            controller.addingIvents(objectName, Date.valueOf(inventDate), inventName, inventType);
                            break;
                        }
                        case "2": {
                            System.out.println("Введите имя объекта");
                            String objectName = scanner.nextLine();
                            System.out.println("Введите дату проведения мероприятия");
                            String inventDate = scanner.nextLine();
                            System.out.println("Введите имя мероприятия");
                            String inventName = scanner.nextLine();
                            System.out.println("Введите тип мероприятия");
                            String inventType = scanner.nextLine();
                            System.out.println("Введите новое имя объекта");
                            String newObjectName = scanner.nextLine();
                            System.out.println("Введите новую дату проведения мероприятия");
                            String newInventDate = scanner.nextLine();
                            System.out.println("Введите новое имя мероприятия");
                            String newInventName = scanner.nextLine();
                            System.out.println("Введите новый тип мероприятия");
                            String newInventType = scanner.nextLine();
                            controller.updatingIvents(objectName, Date.valueOf(inventDate), inventName, inventType, newObjectName, Date.valueOf(newInventDate), newInventName, newInventType);
                            break;
                        }
                        case "3": {
                            System.out.println("Введите имя объекта");
                            String objectName = scanner.nextLine();
                            System.out.println("Введите дату проведения мероприятия");
                            String inventDate = scanner.nextLine();
                            System.out.println("Введите имя мероприятия");
                            String inventName = scanner.nextLine();
                            System.out.println("Введите тип мероприятия");
                            String inventType = scanner.nextLine();
                            controller.deletingIvents(objectName, Date.valueOf(inventDate), inventName, inventType);
                            break;
                        }
                    }
                    break;
                }
                case "5": {
                    Date currentDate = new Date(System.currentTimeMillis());
                    controller.findingObjectsOnCurrutDate(currentDate);
                    break;
                }
                case "6": {
                    Date currentDate = new Date(System.currentTimeMillis());
                    controller.findingIventsTwoWeekAhead(currentDate);
                    break;
                }
                case "7":{
                    System.out.println("Введите тип объекта");
                    String objectType = scanner.nextLine();
                    Date currentDate = new Date(System.currentTimeMillis());
                    controller.findObjectsOnType(objectType, currentDate);
                    break;
                }
            }
        }
    }
}
