
public class Garage {
    public static void main(String[] args){
        //Instanzio la classe
        Auto auto = new Auto();
        auto.marca=" maserati";
        auto.prezzo= 80000;
        auto.modello= "grecale";
        auto.anno=2015;
        auto.mostraInfo();
        //Seconda auto
        Auto auto2 = new Auto();
        auto2.marca="nissan";
        auto2.modello="juke";
        auto2.anno=2007;
        auto2.prezzo=15000;
        auto2.mostraInfo();
    }
    
}
