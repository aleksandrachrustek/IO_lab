package Controller;

import Model.Lot;
import Model.Rezerwacja.PotwierdzenieZamowienia;
import Model.Rezerwacja.Zamowienie;
import Model.SystemLogowania;

import java.util.ArrayList;
import java.util.List;

public class Aplikacja {
    private ArrayList<Lot> katalogLotow = new ArrayList<>();
    private SystemLogowania sesjaUzytkownika = new SystemLogowania();
    private ArrayList<PotwierdzenieZamowienia> historiaZamowien = new ArrayList<>();
    private Zamowienie realizowaneZamowienie;

    public Aplikacja(){}
    static void main(String[] args){}
    public void setKatalog(List<Lot> kat){}
    public void wyswietlKatalog(){}
    public void rezerwujBilety(int nr_lotu, int ilosc_biletow){}
    public void wyswietlPotwierdzenieZamowienia(int idPotwierdzenia){}
    public void zarzadzanieLotami(){}
    private boolean dodajLot(String[] dane){return false;}
    private Lot wyszukajLot(String param){return null;}
    private void wyswietlBlad(String komunikat){}
}
