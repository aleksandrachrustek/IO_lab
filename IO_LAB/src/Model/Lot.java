package Model;

import java.util.Date;

public class Lot {
    private int nr_lotu;
    private int iloscMiejsc;
    private int iloscWolnychMiejsc;
    private String lotnisko_poczatkowe;
    private String lotnisko_docelowe;
    private Date data_wylotu;
    private String przewoznik;
    private float cenaZaMiejsce;

    public Lot(int nr_lotu, int iloscMiejsc, int iloscWolnychMiejsc, String lotnisko_poczatkowe,
               String lotnisko_docelowe, Date data_wylotu, String przewoznik, float cenaZaMiejsce){
    }
    public Lot(String[] informacjeOLocie){}
    public int getNrLotu(){return nr_lotu;}
    public int getIloscMiejsc(){return iloscMiejsc;}
    public int getIloscWolnychMiejsc(){return iloscWolnychMiejsc;}
    public String getLotnisko_poczatkowe(){return lotnisko_poczatkowe;}
    public String getLotnisko_docelowe(){return lotnisko_docelowe;}
    public Date getData_wylotu(){return data_wylotu;}
    public String getPrzewoznik(){return przewoznik;}
    public float getCenaZaMiejsce(){return cenaZaMiejsce;}
}
