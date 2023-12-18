package Model.Rezerwacja;

public class SystemPlatnosci {
    private float kwota;
    private boolean czyPlatnoscKarta;

    public SystemPlatnosci(float kwota, boolean czyPlatnoscKarta){
    };

    public WynikPlatnosci przetworzeniePlatnosci(float kwota, boolean czyPlatnoscKarta){
        return null;
    };
    public boolean autoryzacjaBanku(){return false;}
    public boolean getCzyPlatnoscKarta(){return czyPlatnoscKarta;}
    public void wygenerujPotwierdzenie(){}
}

 enum WynikPlatnosci{
    BLAD_KARTA,
     DO_OPLACENIA,
     OPLACONA_KARTA
}