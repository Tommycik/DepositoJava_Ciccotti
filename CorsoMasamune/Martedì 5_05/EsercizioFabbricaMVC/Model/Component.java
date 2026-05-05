package EsercizioFabbricaMVC.Model;
//interfaccia per rappresentare un componente
public interface Component {
    //metodo astratto per la descrizione
    String getDescrizione();
    //metodi astratti per il nome e la targa
    String getNome();
    String getTarga();

}
