package tech.codoverse;

import java.sql.DriverManager;
import java.sql.SQLException;

public class InvoiceRepository {

    private static final String URL = "jdbc:postgresql://localhost:5432/invoice_db";
    private static final String USR = "invoiceadm";
    private static final String PWD = "invoicepass";

    public void save(Invoice invoice) {
        try (var conn = DriverManager.getConnection(URL, USR, PWD);
                var stmt = conn.createStatement()) {

            stmt.execute("insert into invoice values (%d, %s)");

        } catch (SQLException _) {

        }
    }

}
