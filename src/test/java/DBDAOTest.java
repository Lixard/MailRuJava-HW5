import db.tables.daos.NomenclatureDao;
import db.tables.pojos.Nomenclature;
import org.flywaydb.core.Flyway;
import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.jooq.impl.DefaultConfiguration;
import org.junit.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBDAOTest {

    private static final String URL = "jdbc:postgresql://127.0.0.1:5432/MailRuHW4";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "123";

    private Connection connection;
    private DSLContext dslContext;
    private Configuration configuration;

    @BeforeClass
    public static void FlywayConfigure() throws SQLException {
        final Flyway flyway = Flyway.configure().dataSource(URL, USERNAME, PASSWORD).load();
        flyway.clean();
        flyway.migrate();
    }

    @Before
    public void setConnection() throws SQLException {
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        dslContext = DSL.using(connection, SQLDialect.POSTGRES_10);
        configuration = new DefaultConfiguration().set(connection).set(SQLDialect.POSTGRES_10);
    }

    @Test
    public void insertNomenclatureTest() {
        NomenclatureDao nomenclatureDao = new NomenclatureDao(configuration);
        Nomenclature nomenclature = new Nomenclature((long) 100, "New nomenclature", (long) 91238);
        nomenclatureDao.insert(nomenclature);
        Assert.assertEquals(nomenclature.getCode(), nomenclatureDao.fetchOneById((long) 100).getCode());
    }

    @Test
    public void updateNomenclatureTest() {
        NomenclatureDao nomenclatureDao = new NomenclatureDao(configuration);
        Nomenclature nomenclature = new Nomenclature((long) 101, "New nomenclature", (long) 91238);
        nomenclatureDao.insert(nomenclature);
        Nomenclature nomenclature1 = new Nomenclature((long) 101, "Changed nomenclature", (long) 123456);
        nomenclatureDao.update(nomenclature1);
        Assert.assertEquals(nomenclature1.getCode(),nomenclatureDao.fetchOneById((long) 101).getCode());
    }

    @Test(expected = NullPointerException.class)
    public void deleteNomenclatureTest() {
        NomenclatureDao nomenclatureDao = new NomenclatureDao(configuration);
        Nomenclature nomenclature = new Nomenclature((long) 102, "New nomenclature",(long) 12335);
        nomenclatureDao.insert(nomenclature);
        nomenclatureDao.delete(nomenclature);
        System.out.println(nomenclatureDao.fetchOneById((long) 102).toString());
    }

    @After
    public void closeConnection() throws SQLException {
        dslContext.close();
        connection.close();
    }
}
