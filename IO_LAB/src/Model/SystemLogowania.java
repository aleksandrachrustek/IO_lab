package Model;

import java.util.HashMap;

public class SystemLogowania {
    private boolean zalogowanyJakoPracownik = false;
    private HashMap<String, String> bazaLoginow;

    public SystemLogowania(){};
    public boolean zaloguj(String login, String haslo){
        return false;
    }
    public void wyloguj(){}
    public boolean czyZalogowanyJakoPracownik(){
        return false;
    }
}
