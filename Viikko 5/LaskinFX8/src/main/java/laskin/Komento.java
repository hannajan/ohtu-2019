
package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public abstract class Komento {
    TextField tuloskentta;
    TextField syotekentta;
    Button nollaa;
    Button undo;
    Sovelluslogiikka sovellus;
    int arvo = 0;
    
    public Komento(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.tuloskentta=tuloskentta;
        this.syotekentta=syotekentta;
        this.nollaa=nollaa;
        this.undo=undo;
        this.sovellus=sovellus;
    }
    
    public abstract void suorita();

    void peru() {
        System.out.println("undo pressed");
    }
    
}
