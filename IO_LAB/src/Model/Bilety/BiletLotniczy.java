package Model.Bilety;

import java.util.Date;

public class BiletLotniczy extends Bilet {
    public Date data_wylotu;
    public String miejsce_w_samolocie;
    public String lotnisko_poczatkowe;
    public String lotnisko_docelowe;
    public int nr_lotu;
    public String przewoznik;
    public RodzajBagazu rodzajBagazu;

    public BiletLotniczy(float cena, String imie, String nazwisko, String pesel, TypBiletu typ,
                      Date data_wylotu, String miejsceWSamolocie, String lotniskoPocz,
                      String lotniskoDocelowe, String nrLotu, String przewoznik) {
        super(cena, imie, nazwisko, pesel, typ);}

    public Date getData_wylotu(){return data_wylotu;}
    public String getMiejsce_w_samolocie(){return miejsce_w_samolocie;}
    public String getLotnisko_poczatkowe() {return lotnisko_poczatkowe;}
    public String getLotnisko_docelowe(){return lotnisko_docelowe;}
    public int getNr_lotu(){return nr_lotu;}
    public String getPrzewoznik(){return przewoznik;}
    public String wypiszInformacje(){
        super.wypiszInformacje();
        return null;
    }
    public RodzajBagazu getRodzajBagazu(){return rodzajBagazu;}

}
