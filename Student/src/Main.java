
public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Karol", "Kowalski", 2.7, 'M', "Matematyka");
        Student s2 = new Student("Anna", "Nowak", 3.1, 'K', "Matematyka");
        Student s3 = new Student("Patrycja", "Wiśniewska", 4.0, 'K', "Mechatronik");
        Student s4 = new Student("Filip", "Zieliński", 5.1, 'M', "Logistyka");

        s1.ZmienImie("Karolina");
        s1.ZmienNazwisko("Kowalska");
        s1.ZmienKierunek("Fizyka");
        s2.ZmienOcene(4.2);
        s1.UstawPlec('K');
        System.out.println();


        System.out.println("Czy " + s1.getImie() + " zaliczył(a) przedmiot? " + (s1.SprawdzZaliczenie() ? "Tak" : "Nie"));
        System.out.println("Czy " + s2.getImie() + " zaliczył(a) przedmiot? " + (s2.SprawdzZaliczenie() ? "Tak" : "Nie"));
        System.out.println("Czy " + s3.getImie() + " zaliczył(a) przedmiot? " + (s3.SprawdzZaliczenie() ? "Tak" : "Nie"));
        System.out.println("Czy " + s4.getImie() + " zaliczył(a) przedmiot? " + (s4.SprawdzZaliczenie() ? "Tak" : "Nie"));
        System.out.println();

        Student.WyswietlSredniaOcenaKierunku("Matematyka");
        Student.WyswietlSredniaOcenaKierunku("Logistyka");
        Student.WyswietlSredniaOcenaKierunku("Mechatronik");
    }
}