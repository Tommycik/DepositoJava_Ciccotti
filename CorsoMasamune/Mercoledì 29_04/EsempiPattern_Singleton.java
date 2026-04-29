public class EsempiPattern_Singleton {
    // Istanza dell'oggetto Singleton
    private static EsempiPattern_Singleton instance;
    // Costruttore privato
    private EsempiPattern_Singleton() {}
    // Metodo per ottenere l'istanza
    public static EsempiPattern_Singleton getInstance() {
        if (instance == null) {
            // Se non esiste un'istanza, creala
            instance = new EsempiPattern_Singleton();
        }
        return instance;
    }
    // Metodo che esegue qualcosa
    public void doSomething() {
        System.out.println("Esempio Singleton, doSomething() chiamato"); 
    }
    
}
