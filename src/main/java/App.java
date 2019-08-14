import db.tables.Nomenclature;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static db.tables.Nomenclature.NOMENCLATURE;

public class App {

    private static final String URL = "jdbc:postgresql://127.0.0.1:5432/MailRuHW4";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "123";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD)) {
            DSLContext create = DSL.using(connection, SQLDialect.POSTGRES_10);

            Result<Record> result = create.select().from(NOMENCLATURE).fetch();

            for (Record r : result) {
                long id = r.getValue(NOMENCLATURE.ID);
                String name = r.getValue(NOMENCLATURE.NAME);
                long code = r.getValue(NOMENCLATURE.CODE);
                System.out.println("id: " + id + " name: " + name + " code: " + code);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
