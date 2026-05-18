import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class EsercizioJdbc {

    public static void main(String[] args) {

        ConnectionManager cm = new ConnectionManager();

        try {
            //prendo connessione dal manager
            Connection conn = cm.connect();

            // creo statement
            Statement stmt = conn.createStatement();

            // prime 10 città
            String query = "SELECT * FROM City LIMIT 10";

            // eseguo query
            ResultSet rs = stmt.executeQuery(query);

            //stampo risultati
            while (rs.next()) {
                System.out.println(
                    rs.getInt("ID") + " - " +
                    rs.getString("Name") + " - " +
                    rs.getInt("Population")
                );
            }

            // chiudo connessione
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}