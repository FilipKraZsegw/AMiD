import java.util.ArrayList;
class Student {
    private String imie;
    private String nazwisko;
    private double ocena;
    private char plec;
    private String kierunek;

    public String getImie() {
        return imie;
    }

    private static double sumaOcen = 0;
    private static int liczbaStudentow = 0;
    private static final ArrayList<Student> studenci = new ArrayList<>();

    public Student(String imie, String nazwisko, double ocena, char plec, String kierunek) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.ocena = ocena;
        this.plec = plec;
        this.kierunek = kierunek;

        sumaOcen += ocena;
        liczbaStudentow++;
        studenci.add(this);
    }

    public void WyswietlInformacje() {
        System.out.println("Imię: " + imie);
        System.out.println("Nazwisko: " + nazwisko);
        System.out.println("Ocena: " + ocena);
        System.out.println("Płeć: " + plec);
        System.out.println("Kierunek: " + kierunek);
    }

    public void ZmienKierunek(String nowyKierunek) {
        this.kierunek = nowyKierunek;
        System.out.println("Zmieniono kierunek studiów na: " + nowyKierunek);
        WyswietlInformacje();
    }

    public void ZmienOcene(double nowaOcena) {
        sumaOcen = sumaOcen - this.ocena + nowaOcena;
        this.ocena = nowaOcena;
        System.out.println("Zmieniono ocenę.");
        WyswietlInformacje();
    }

    public void ZmienImie(String noweImie) {
        System.out.println("Zmieniono imie ucznia " + this.imie + " " + this.nazwisko + " na " + noweImie);
        this.imie = noweImie;
    }

    public void ZmienNazwisko(String noweNazwisko) {
        System.out.println("Zmieniono nazwisko ucznia " + this.imie + " " + this.nazwisko + " na " + noweNazwisko);
        this.nazwisko = noweNazwisko;
    }

    public void UstawPlec(char nowaPlec) {
        this.plec = nowaPlec;
        System.out.println("Zmieniono płeć ucznia " + this.imie + " na " + nowaPlec);
    }

    public double ObliczSredniaOcen() {
        return this.ocena;
    }

    public boolean SprawdzZaliczenie() {
        return this.ocena >= 3.0;
    }

    public static void WyswietlSredniaOcenaKierunku(String kierunek) {
        double sumaOcen = 0;
        int liczbaStudentowNaKierunku = 0;

        for (Student student : studenci) {
            if (student.kierunek.equals(kierunek)) {
                sumaOcen += student.ocena;
                liczbaStudentowNaKierunku++;
            }
        }

        if (liczbaStudentowNaKierunku > 0) {
            double srednia = sumaOcen / liczbaStudentowNaKierunku;
            System.out.println("Średnia ocena studentów na kierunku " + kierunek + ": " + srednia);
        } else {
            System.out.println("Brak studentów na kierunku " + kierunek);
        }
    }

    public static void WyswietlSredniaOcena() {
        if (liczbaStudentow > 0) {
            double srednia = sumaOcen / liczbaStudentow;
            System.out.println("Średnia ocena wszystkich studentów: " + srednia);
        } else {
            System.out.println("Brak studentów.");
        }
    }
}