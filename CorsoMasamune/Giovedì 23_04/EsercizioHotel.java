import java.util.ArrayList;

class Camera {
    private int numero;
    private float prezzo;

    //Costruttore
    public Camera(int numero, float prezzo) {
        this.numero = numero;
        this.prezzo = prezzo;
    }
    //Getter
    public int getNumero() {
        return numero;
    }

    public float getPrezzo() {
        return prezzo;
    }
    //Setter
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public void dettagli() {
        System.out.println("Camera numero: " + numero + " prezzo: " + prezzo);
    }
    //Overload dettagli
    public void dettagli(boolean conPrezzo) {
        if (conPrezzo) {
            System.out.println("Camera numero: " + numero + " prezzo: " + prezzo);
        } else {
            System.out.println("Camera numero: " + numero);
        }
    }
}

class Suite extends Camera {
    private String serviziExtra;
    //Costruttore
    public Suite(int numero, float prezzo, String serviziExtra) {
        super(numero, prezzo);
        this.serviziExtra = serviziExtra;
    }
    //Getter
    public String getServiziExtra() {
        return serviziExtra;
    }
    //Setter
    public void setServiziExtra(String serviziExtra) {
        this.serviziExtra = serviziExtra;
    }
    //Overload dettagli()
    @Override
    public void dettagli() {
        super.dettagli();
        System.out.println("Servizi extra della suite: " + serviziExtra);
    }
    //Overload dettagli(boolean)
    @Override
    public void dettagli(boolean conPrezzo) {
        super.dettagli(conPrezzo);
        System.out.println("Servizi extra della suite: " + serviziExtra);
    }

}

class Hotel{
    private String nome;
    private ArrayList<Camera> camere = new ArrayList<Camera>();

    //Costruttore
    public Hotel(String nome) {
        this.nome = nome;
    }
    //Getter
    public String getNome() {
        return nome;
    }
    public ArrayList<Camera> getCamere() {
        return camere;
    }

    //Setter
    public void setNome(String nome) {
        this.nome = nome;
    }

    //Aggiunge una camera
    public void aggiungiCamera(Camera nuovaCamera) {
        if(camere == null) {
            System.out.println("Camera non valida");
            return;
        }
        //Controlla che numero camera non sia già presente
        for (Camera camera : camere) {
            if (camera.getNumero() == nuovaCamera.getNumero()) {
                System.out.println("Camera con questo numero già presente");
                return;
            }
        }
        this.camere.add(nuovaCamera);
    }

    static public int contaSuite(ArrayList<Camera> camere) {
        int suite = 0;
        for (Camera camera : camere) {
            if (camera instanceof Suite) {
                suite++;
            }
        }
        return suite;
    }

    //Dettagli hotel
    public void dettagli() {
        System.out.println("Nome: " + nome);
        System.out.println("Camere: ");
        for (Camera camera : camere) {
            camera.dettagli();
        }
    }

    // Dettagli hotel con prezzo
    public void dettagli(boolean conPrezzo) {
        System.out.println("Nome: " + nome);
        System.out.println("Camere: ");
        for (Camera camera : camere) {
            camera.dettagli(conPrezzo);
        }
    }
}    

public class EsercizioHotel {
    public static void main(String[] args) {
        //creazione hotel
        Hotel hotel = new Hotel("Hotel del Corso");
        //Prova camera 
        Camera camera = new Camera(1, 100);
        //Prova overload dettagli
        camera.dettagli();
        camera.dettagli(false);
        //Creazione camere normali
        hotel.aggiungiCamera(new Camera(1, 100));
        hotel.aggiungiCamera(new Camera(2, 200));
        hotel.aggiungiCamera(new Camera(3, 300));
        //Creazione suite
        hotel.aggiungiCamera(new Suite(4, 400, "TV"));
        hotel.aggiungiCamera(new Suite(5, 500, "Aria condizionata"));
        hotel.aggiungiCamera(new Suite(6, 600, "Piscina"));
        //prova con camera con numero già presente
        hotel.aggiungiCamera(new Camera(5, 700));
        //dettali hotel
        hotel.dettagli();
        //numero suite
        System.out.println("Numero suite: " + Hotel.contaSuite(hotel.getCamere()));
    }
}

