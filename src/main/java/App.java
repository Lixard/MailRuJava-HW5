import QueryEntities.OrganizationWithAmount;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;


public final class App {

    private static final String URL = "jdbc:postgresql://127.0.0.1:5432/MailRuHW4";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "123";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD)) {
            DSLContext dslContext = DSL.using(connection, SQLDialect.POSTGRES_10);
            Queries queries = new Queries(dslContext);

            List<OrganizationWithAmount> list1 = queries.top10OrganizationsByAmountOfGoods();
            System.out.println(Arrays.toString(list1.toArray()));

//            List<DataAmountPrice> list3 = queries.AmountAndPricePerPeriodEveryDay("2019-03-11" , "2019-03-13");
//            System.out.println(Arrays.toString(list3.toArray()));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
