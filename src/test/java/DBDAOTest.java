import db.tables.daos.NomenclatureDao;
import db.tables.daos.OrganizationsDao;
import db.tables.daos.PositionsDao;
import db.tables.pojos.Nomenclature;
import db.tables.pojos.Organizations;
import db.tables.pojos.Positions;
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
        Assert.assertEquals(nomenclature1.getCode(), nomenclatureDao.fetchOneById((long) 101).getCode());
    }

    @Test(expected = NullPointerException.class)
    public void deleteNomenclatureTest() {
        NomenclatureDao nomenclatureDao = new NomenclatureDao(configuration);
        Nomenclature nomenclature = new Nomenclature((long) 102, "New nomenclature", (long) 12335);
        nomenclatureDao.insert(nomenclature);
        nomenclatureDao.delete(nomenclature);
        System.out.println(nomenclatureDao.fetchOneById((long) 102).toString());
    }

    @Test
    public void insertOrganizationsTest() {
        OrganizationsDao organizationsDao = new OrganizationsDao(configuration);
        Organizations organization = new Organizations((long) 100, "New organization", (long) 1235512, (long) 31231231);
        organizationsDao.insert(organization);
        Assert.assertEquals(organization.getInn(), organizationsDao.fetchOneById((long) 100).getInn());
    }

    @Test
    public void updateOrganizationsTest() {
        OrganizationsDao organizationsDao = new OrganizationsDao(configuration);
        Organizations organization = new Organizations((long) 101, "New organization", (long) 1235512, (long) 31231231);
        organizationsDao.insert(organization);
        Organizations organization2 = new Organizations((long)101, "Updated organization", (long) 123145, (long) 321394);
        organizationsDao.update(organization2);
        Assert.assertEquals(organization2.getInn(), organizationsDao.fetchOneById((long) 101).getInn());
    }

    @Test(expected = NullPointerException.class)
    public void deleteOrganizationsTest() {
        OrganizationsDao organizationsDao = new OrganizationsDao(configuration);
        Organizations organization = new Organizations((long) 102, "New organization", (long) 1235512, (long) 31231231);
        organizationsDao.insert(organization);
        organizationsDao.delete(organization);
        System.out.println(organizationsDao.fetchOneById((long) 102));
    }

    @Test
    public void insertPositionsTest() {
        PositionsDao positionsDAO = new PositionsDao(configuration);
        NomenclatureDao nomenclatureDAO = new NomenclatureDao(configuration);
        Nomenclature nomenclature = new Nomenclature((long)20,"New Nomenclature",(long)123456);
        Positions position = new Positions((long)20,(long)1,(long) 500,(long) 200);
        nomenclatureDAO.insert(nomenclature);
        Assert.assertEquals(position.getWaybillId(), positionsDAO.fetchOneByNomenclatureId((long) 20).getWaybillId());
    }

    @Test
    public void updatePositionsTest() {
        PositionsDao positionsDAO = new PositionsDao(configuration);
        NomenclatureDao nomenclatureDAO = new NomenclatureDao(configuration);
        Nomenclature nomenclature = new Nomenclature((long)200,"New Nomenclature",(long)123456);
        Positions position = new Positions((long)200,(long) 1, (long) 500, (long) 200);
        Positions position2 = new Positions((long) 200, (long) 2, (long) 300, (long) 150);
        Assert.assertEquals(position2.getWaybillId(), positionsDAO.fetchOneByNomenclatureId((long)200).getWaybillId());

    }

    @After
    public void closeConnection() throws SQLException {
        dslContext.close();
        connection.close();
    }
}
