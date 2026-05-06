package EsercizioComputer.Model;

interface StrategySistemaOperativo {
    String modifica(String messaggio);
}
//Strategie Concrete
class ConcreteStrategyLinux implements StrategySistemaOperativo {
    public String modifica(String messaggio) {
        return messaggio + " Linux";
    }
}
class ConcreteStrategyWindows implements StrategySistemaOperativo {
    public String modifica(String messaggio) {
        return messaggio + " Windows";
    }
}
