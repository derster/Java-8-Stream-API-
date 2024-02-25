package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class Demo1Application{

    public static void main(String[] args) {

        SpringApplication.run(Demo1Application.class, args);

        Runnable runnable = () -> {
            System.out.println("Le thread démarre !");
            for (int i = 0; i < 5; i++) {
                System.out.println("Hello from MonThread " + i);
                try {
                    Thread.sleep(3000); // Pause d'une seconde entre chaque message
                } catch (InterruptedException e) {
                    System.err.println("Thread interrompu !");
                }
            }
            System.out.println("Le thread se termine.");
        };

        Thread thread = new Thread(runnable);
        thread.start();


        Calculator calculator = (int input1, int input2)-> System.out.println("Sum: "+ (input1+input2));

        calculator.sum(50, 80);

        BookService bookService = new BookService();

        System.out.println(bookService.getBookInSort());


        List<String> fruits = Arrays.asList("Pomme", "Banane", "Orange", "Mangue");

        Consumer<String> afficherFruit = fruit -> System.out.println("Fruit : " + fruit);

        fruits.forEach(afficherFruit);


        List<Integer> nombres = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Utilisation de l'interface Predicate pour filtrer les nombres pairs
        Predicate<Integer> estPair = nombre -> nombre % 2 == 0;

        /*List<Integer> nombresPairs = nombres.stream()
                .filter(nombre -> (nombre % 2==0))
                .toList();*/

        List<Integer> nombresPairs = filtrer(nombres, estPair);

        System.out.println("Nombres pairs : " + nombresPairs);

        // Utilisation de l'interface Supplier pour fournir des valeurs aléatoires
        Supplier<Integer> generateurAleatoire = () -> new Random().nextInt(100);

        // Afficher 5 valeurs aléatoires
        for (int i = 0; i < 5; i++) {
            int valeur = generateurAleatoire.get();
            System.out.println("Valeur aléatoire : " + valeur);
        }

        List<Book> books = new BookDAO().getBooks();

        for (Book book: new BookDAO().getBooks()){
            System.out.println(book.getName());
        }

        Consumer<Book> consumer = System.out::println;
        Predicate<Book> predicate = book -> book.getName().contains("Core");
        Comparator<Book> comparator = Comparator.comparing(Book::getPrice).reversed();

        Map<Integer, List<Book>> collect = books.stream().filter(predicate)
                .collect(Collectors.groupingBy(Book::getId));

        books.sort(comparator);

        System.out.println(collect);

        TaxService taxService = new TaxService();

        System.out.println(taxService.goupyBy());
        System.out.println(taxService.sortEmployees());

        taxService.sortForeach();

        System.out.println(taxService.sortedStr());

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(MapDemo.map().entrySet());

        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        Collections.sort(entries, (o1, o2) -> o2.getValue()-o1.getValue());

        for (Map.Entry<String, Integer> entry: entries){
            System.out.println(entry.getKey()+ " : "+entry.getValue());
        }

        MapDemo.map().entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(
                System.out::println
        );
        System.out.println("-------------------");

        MapDemo.map().entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(
                System.out::println
        );
        EmployeeDAO.getEmployeeMap().forEach((employee, integer) -> System.out.println(employee));

    }

    public static <T> List<T> filtrer(List<T> liste, Predicate<T> predicate) {
        return liste.stream()
                .filter(predicate)
                .toList();
    }

}

class MapDemo{
    public static Map<String, Integer> map(){
        Map<String, Integer> map = new HashMap<>();
        map.put("eight", 8);
        map.put("four", 4);
        map.put("ten", 10);
        map.put("two", 2);
        return map;
    }
}

@FunctionalInterface
interface Calculator{
    void sum(int input, int input2);
}


