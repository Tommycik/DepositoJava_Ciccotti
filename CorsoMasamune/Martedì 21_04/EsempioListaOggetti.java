    import java.util.ArrayList;

public class EsempioListaOggetti {

    public static void main(String[] args) {

        ArrayList<Auto> autoList = new ArrayList<>();

        autoList.add(new Auto("Tesla", 2023));

        autoList.add(new Auto("Ford", 2020));
        autoList.add(new Auto("Ford", 2022));
        //Controllo equals
        for (Auto auto : autoList) {
            System.out.println(auto.equals(new Auto("Ford", 2020)));
        }

        for (Auto auto : autoList) {
            System.out.println(auto.marca + " - " + auto.anno);
            //Controllo toString
            System.out.println(auto.toString());
            //Controllo hashCode
            System.out.println(auto.hashCode());
        }

    }
}

//classe auto
class Auto {
    String marca;
    int anno;

    //Override metodo equals
    @Override
    public boolean equals(Object o) {
        //Controlla indirizzo memoria o se è null
        if (o == null){
            return false;
        }else if(this == o){
            return true;
        }
        //Controlla tipo
        //oppure getClass() == o.getClass()
        if (o instanceof Auto) {
            Auto auto = (Auto) o;
            //Controlla attributi
            return marca.equals(auto.marca) && anno == auto.anno;
        }
        return false;
    }

    //override hashCode
    @Override
    public int hashCode() {
        int result = marca.hashCode()*31;
        result +=result*31 + anno;
        return result;
    }

    //override toString
    @Override
    public String toString() {
        return "Marca: " + marca + " Anno: " + anno;
    }
    // costruttore
    Auto(String marca, int anno) {
        this.marca = marca;
        this.anno = anno;

    }

}

