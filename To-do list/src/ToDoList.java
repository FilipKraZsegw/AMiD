import java.util.ArrayList;
import java.util.Scanner;

class Zadanie {
    private String tresc;
    private String opis;
    private boolean wykonanie;

    public Zadanie(String tresc, String opis) {
        this.tresc = tresc;
        this.opis = opis;
        this.wykonanie = false;
    }

    public String getTresc() {
        return tresc;
    }

    public void ustawJakoWykonane() {
        this.wykonanie = true;
    }

    @Override
    public String toString() {
        String status = wykonanie ? "[x]" : "[ ]";
        return status + " " + tresc + ": " + opis;
    }
}

public class ToDoList {
    private ArrayList<Zadanie> Zadania;
    private Scanner scanner;

    public ToDoList() {
        Zadania = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void showMenu() {
        int wybor;
        do {
            System.out.println("\n1. Dodaj nowe zadanie");
            System.out.println("2. Oznacz zadanie jako zakończone");
            System.out.println("3. Usuń zadanie");
            System.out.println("4. Wyświetl listę zadań");
            System.out.println("5. Wyjście");
            System.out.print("Wybierz opcję (1/2/3/4/5): ");
            wybor = scanner.nextInt();
            scanner.nextLine();

            switch (wybor) {
                case 1:
                    dodajZadanie();
                    break;
                case 2:
                    odznaczWykonane();
                    break;
                case 3:
                    usunZadanie();
                    break;
                case 4:
                    Wyswietl();
                    break;
                case 5:
                    System.out.println("Koniec programu.");
                    break;
                default:
                    System.out.println("Nieprawidłowa opcja. Spróbuj ponownie.");
            }
        } while (wybor != 5);
    }

    private void dodajZadanie() {
        System.out.print("Podaj nazwę zadania: ");
        String tresc = scanner.nextLine();
        System.out.print("Podaj opis zadania: ");
        String opis = scanner.nextLine();
        Zadanie zadanie = new Zadanie(tresc, opis);
        Zadania.add(zadanie);
        System.out.println("Zadanie \"" + tresc + "\" zostało dodane do listy.");
    }

    private void odznaczWykonane() {
        Wyswietl();
        if (Zadania.isEmpty()) return;

        System.out.print("Podaj numer zadania do oznaczenia jako zakończone: ");
        int taskNumber = scanner.nextInt();
        scanner.nextLine();
        if (taskNumber > 0 && taskNumber <= Zadania.size()) {
            Zadanie zadanie = Zadania.get(taskNumber - 1);
            zadanie.ustawJakoWykonane();
            System.out.println("Zadanie \"" + zadanie.getTresc() + "\" zostało oznaczone jako zakończone.");
        } else {
            System.out.println("Nieprawidłowy numer zadania.");
        }
    }

    private void usunZadanie() {
        Wyswietl();
        if (Zadania.isEmpty()) return;

        System.out.print("Podaj numer zadania do usunięcia: ");
        int taskNumber = scanner.nextInt();
        scanner.nextLine();
        if (taskNumber > 0 && taskNumber <= Zadania.size()) {
            Zadanie removedTask = Zadania.remove(taskNumber - 1);
            System.out.println("Zadanie \"" + removedTask.getTresc() + "\" zostało usunięte z listy.");
        } else {
            System.out.println("Nieprawidłowy numer zadania.");
        }
    }

    private void Wyswietl() {
        if (Zadania.isEmpty()) {
            System.out.println("Lista zadań jest pusta.");
        } else {
            System.out.println("Lista zadań:");
            for (int i = 0; i < Zadania.size(); i++) {
                System.out.println((i + 1) + ". " + Zadania.get(i));
            }
        }
    }

    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        toDoList.showMenu();
    }
}
