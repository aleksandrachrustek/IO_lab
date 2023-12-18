package Model.Rezerwacja;

import Model.Bilety.Bilet;
import Model.Rezerwacja.PotwierdzenieZamowienia;
import Model.Rezerwacja.SystemPlatnosci;

import java.util.ArrayList;
import java.util.List;

public class Zamowienie {
    private List<Bilet> zamowione_bilety = new ArrayList<>();
    private SystemPlatnosci systemPlatnosci;
    private PotwierdzenieZamowienia wygenerujPotwierdzenie(boolean oplacone, float kwota){return null;}

    public Zamowienie(ArrayList<Bilet> zamowione_bilety){}
    public float obliczCalkowitaKwote(){return 0.0f;}
    public PotwierdzenieZamowienia zrealizujZamowienie(float kwota, boolean czyPlatnoscKarta, String nrKontaBank){
        return null;
    }
}
