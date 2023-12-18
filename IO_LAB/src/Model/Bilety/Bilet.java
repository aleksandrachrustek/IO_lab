package Model.Bilety;

public abstract class Bilet {
    private float cena;
    private String imie;
    private String nazwisko;
    private String pesel;
    private TypBiletu typ;

    public Bilet(float cena, String imie, String nazwisko, String pesel, TypBiletu typ){}
    public TypBiletu getTyp(){return null;};
    public float getCena(){return 0.0f;}
    public String getImie(){return null;}
    public String getNazwisko(){return null;}
    public String getPesel(){return null;}
    public String wypiszInformacje(){return null;}
}

