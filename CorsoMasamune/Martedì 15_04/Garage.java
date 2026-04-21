import java.util.ArrayList;

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
        // le metto in una lista
        ArrayList<Auto> auto_o = new ArrayList<>();
        auto_o.add(auto);
        auto_o.add(auto2);
        //ora posso usare il for each
        for(Auto a : auto_o){
            a.mostraInfo();
            //Meglio se si accede tramite la classe
            System.out.println("Numero di ruote: "+ a.numeroRuote);
        }

    }
    
}
