package Model.Rezerwacja;

public class SystemPlatnosci {
    private float kwota;
    private boolean platnoscKarta;

    public SystemPlatnosci(){
    };

    public WynikPlatnosci przetworzeniePlatnosci(float kwota, boolean czyPlatnoscKarta){
        return null;
    };
    private boolean autoryzacjaBanku(){return false;}
    private boolean czyPlatnoscKarta(){return platnoscKarta;}
    public void wygenerujPotwierdzenie(){}
}

