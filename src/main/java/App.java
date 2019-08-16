import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public final class App {

    private static final String URL = "jdbc:postgresql://127.0.0.1:5432/MailRuHW4";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "123";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD)) {
            DSLContext dslContext = DSL.using(connection, SQLDialect.POSTGRES_10);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
