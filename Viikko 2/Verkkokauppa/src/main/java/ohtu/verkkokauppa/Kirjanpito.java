
package ohtu.verkkokauppa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Kirjanpito {
    
    private ArrayList<String> tapahtumat;

    @Autowired
    public Kirjanpito() {
        tapahtumat = new ArrayList<String>();
    }
    
    public void lisaaTapahtuma(String tapahtuma) {
        tapahtumat.add(tapahtuma);
    }

    public ArrayList<String> getTapahtumat() {
        return tapahtumat;
    }       
}
