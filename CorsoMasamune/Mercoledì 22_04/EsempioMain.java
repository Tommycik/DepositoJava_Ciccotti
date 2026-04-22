
public class EsempioMain {
    public static void main(String[] args) {
        Persona p = new Persona("Tommy", "Ciccotti", 22, "Via Roma, 1", "Italia");
        //metodo pubblico
        p.saluta();
        //getter
        System.out.println("Il suo nome è : " + p.getNome());
        //Setter name
        p.setNome("tom");
        System.out.println("Il suo nome è ora : " + p.getNome());

        p.stampaStatus();
    }
}
