package Model;

import java.util.HashMap;

public class SystemLogowania {
    private boolean zalogowanyJakoPracownik = false;
    private HashMap<String, String> bazaLoginow;
    private String loggedAs;

    public SystemLogowania(){};
    public boolean zaloguj(String login, String haslo){
        return true;
    }
    public void wyloguj(){}
    public boolean czyZalogowanyJakoPracownik(){
        return false;
    }
    public String getUsername(){
        return loggedAs;
    }
}
