package Controller;

import Model.Bilety.Bilet;
import Model.Bilety.BiletLotniczy;
import Model.Bilety.BiletParkingowy;
import Model.Bilety.TypBiletu;
import Model.Lot;
import Model.Rezerwacja.PotwierdzenieZamowienia;
import Model.Rezerwacja.SystemPlatnosci;
import Model.Rezerwacja.WynikPlatnosci;
import Model.Rezerwacja.Zamowienie;
import Model.SystemLogowania;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Aplikacja {
    static void main(String[] args){
        Aplikacja app = new Aplikacja();
        app.zarzadzanieLotami();
        //app.rezerwujBilety(123, 1);
    }
    private ArrayList<Lot> katalogLotow = new ArrayList<>();
    private SystemLogowania sesjaUzytkownika = new SystemLogowania();
    private ArrayList<PotwierdzenieZamowienia> historiaZamowien = new ArrayList<>();
    private Zamowienie realizowaneZamowienie;

    public Aplikacja(){}
    public void setKatalog(List<Lot> kat){}
    public void wyswietlKatalog(){}
    public void rezerwujBilety(int nr_lotu, int iloscBiletow){
        Lot znalezionyLot = wyszukajLot(nr_lotu);
        if (znalezionyLot != null && katalogLotow.indexOf(znalezionyLot) != -1){
            int iloscWolnychMiejsc = znalezionyLot.getIloscWolnychMiejsc();
            if (iloscWolnychMiejsc >= iloscBiletow){
                ArrayList<Bilet> zamowioneBilety = new ArrayList<>();
                for (int i = 0; i < iloscBiletow; i++){
                    BiletLotniczy biletLotniczy = new BiletLotniczy(22.5F, "Czlowiek ", String.valueOf(i),
                            "11223344556", TypBiletu.LOTNICZY, new Date(), "22 pod oknem",
                            "Wroclaw", "Moskwa", String.valueOf(nr_lotu), "Ryanair");
                    zamowioneBilety.add(biletLotniczy);
                }
                boolean czyBiletParkingowy = true; // skad to wziac?
                if (czyBiletParkingowy){
                    Date data1 = new Date();
                    Date data2 = new Date(2025, 10, 20);
                    BiletParkingowy biletPark = new BiletParkingowy(22.5F, "Czlowiek ", "0",
                            "11223344556", TypBiletu.PARKINGOWY,"DWASDXD", data1, data2, '0');
                    zamowioneBilety.add(biletPark);
                }
                Zamowienie realizowaneZamowienie = new Zamowienie(zamowioneBilety);
                SystemPlatnosci systemPlatnosci = new SystemPlatnosci();
                float obliczonaKwota = realizowaneZamowienie.obliczCalkowitaKwote();
                realizowaneZamowienie.zrealizujZamowienie(obliczonaKwota, true, "21938018403");
                //nie rozumiem czemu tak, skoro i tak zwracamy typ PotwierdzenieZamowienia nizej w "wygenerujPotwierdzenie"
                WynikPlatnosci wynikPlatnosci = systemPlatnosci.przetworzeniePlatnosci(obliczonaKwota, true);
                boolean platnoscUdana;
                if (wynikPlatnosci == WynikPlatnosci.OPLACONA_KARTA){
                    platnoscUdana = true;
                }
                else if (wynikPlatnosci == WynikPlatnosci.BLAD_KARTA){
                    platnoscUdana = false;
                }
                else if (wynikPlatnosci == WynikPlatnosci.DO_OPLACENIA){

                }
                PotwierdzenieZamowienia potwierdzenieZamowienia =
                        realizowaneZamowienie.wygenerujPotwierdzenie(wynikPlatnosci, obliczonaKwota); //to musialem zrobic public
                if(potwierdzenieZamowienia != null){
                    String zawartoscPotwierdzenia = potwierdzenieZamowienia.wyswietlZawartosc();//to wyglada na diagramie jakby ta metoda należała do Aplikacji, a nie do Potwierdzenia
                    String idPotwierdzenia = potwierdzenieZamowienia.getIdPotwierdzenia();
                    wyswietlPotwierdzenieZamowienia(idPotwierdzenia, zawartoscPotwierdzenia);
                    historiaZamowien.add(potwierdzenieZamowienia);

                }
            }
            else{
                wyswietlBlad("brak miejsc");
            }

        }
        else{
            wyswietlBlad("nie znaleziono lotu");
        }

    }
    private Lot wyszukajLot(int nrLotu){
        return null;
    }
    public void wyswietlPotwierdzenieZamowienia(String idPotwierdzenia, String zawartoscPotwierdzenia){}
    public void zarzadzanieLotami(){
        SystemLogowania sl = new SystemLogowania();
        int iloscProb = 0;
        System.out.println("Podaj login i haslo");
        String login = System.in.toString();
        String haslo = System.in.toString();
        if (!sl.zaloguj(login, haslo)){
            wyswietlBlad("bledne logowanie");
            iloscProb++;
            if(iloscProb == 3){
                return;
            }
        }
        else{
            String username = sl.getUsername();
            int wybor;
            do {
                wyswietlMenuZarzadzania(username);
                wybor = Integer.parseInt(System.in.toString());
                if (wybor == 1) {
                    String[] dane = new String[]{"123", "123", "123"};
                    if (sprawdzPoprawnoscDanychLot(dane)) {
                        Lot lot = new Lot(dane);
                        katalogLotow.add(lot);
                        for (Lot l : katalogLotow) {
                            System.out.println(l.toString());
                        }
                    }
                    ;
                } else if (wybor == 2) {
                    String parametrWyszukiwania = "123";
                    ArrayList<Lot> znalezioneLoty = wyszukajLotParametr(parametrWyszukiwania);
                    wyswietlListeLotow(znalezioneLoty);
                } else if (wybor == 3) {
                    edytujLot(123, "123", "123");
                }
                else{

                }
            } while (wybor != 0);
            if(wybor == 0){
                sl.wyloguj();
            }
        }
    }
    private void wyswietlMenuZarzadzania(String loggedAs){
        System.out.println("0 - wyloguj, 1 - dodaj lot, 2 - wyszukaj lot, 3 - edytuj lot");
    }
    private boolean sprawdzPoprawnoscDanychLot(String[] informacjeDoWeryfikacji){return true;}
    private ArrayList<Lot> wyszukajLotParametr(String parametrWyszukiwania){
        if (!katalogLotow.isEmpty()){
            return katalogLotow;
        }
        return null;}
    private boolean dodajLot(String[] dane){return false;} //chyba niepotrzebne?
    private void wyswietlListeLotow(ArrayList<Lot> lotyDoWyswietlenia){
        for (Lot l: lotyDoWyswietlenia) {
            System.out.println(l.toString());
        }
    }
    private boolean edytujLot(int nrLotu, String parametr, String wartosc){return false;}
    private void wyswietlBlad(String komunikat){}
}
