package Model.Bilety;

import java.util.Date;

public class BiletParkingowy extends Bilet {
    private String nr_rejestracyjny;
    private Date data_rozpoczecia;
    private Date data_zakonczenia;
    private char strefa;

    public BiletParkingowy(float cena, String imie, String nazwisko, String pesel, TypBiletu typ,
                           String nr_rejestracyjny, Date data_rozpoczecia, Date data_zakonczenia,
                           char strefa) {
        super(cena, imie, nazwisko, pesel, typ);}

    public String wypiszInformacje(){
        super.wypiszInformacje();
        return null;
    }
    public String getNr_rejestracyjny(){return nr_rejestracyjny;}
    public Date getData_rozpoczecia(){return data_rozpoczecia;}
    public Date getData_zakonczenia(){return data_zakonczenia;}
    public char getStrefa(){return strefa;}
}
