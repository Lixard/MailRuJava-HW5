import QueryEntities.DataAmountPrice;
import QueryEntities.OrganizationWithAmount;
import QueryEntities.OrganizationWithGoods;
import QueryEntities.OrganizationWithPrice;
import org.jetbrains.annotations.NotNull;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static db.tables.Organizations.ORGANIZATIONS;
import static db.tables.Positions.POSITIONS;
import static db.tables.Waybills.WAYBILLS;
import static org.jooq.impl.DSL.sum;

public final class Queries {
    @NotNull
    private final DSLContext dslContext;

    public Queries(@NotNull DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    public List<OrganizationWithAmount> top10OrganizationsByAmountOfGoods() {
        Result<Record> result = dslContext.select(ORGANIZATIONS.ID, ORGANIZATIONS.NAME, ORGANIZATIONS.INN,
                ORGANIZATIONS.SETTLEMENT_ACC, sum(POSITIONS.AMOUNT))
                .from(ORGANIZATIONS)
                .join(WAYBILLS).on(ORGANIZATIONS.ID.eq(WAYBILLS.ORG_SEND_ID))
                .join(POSITIONS).on(WAYBILLS.ORG_SEND_ID.eq(POSITIONS.WAYBILL_ID))
                .groupBy(ORGANIZATIONS.ID).orderBy(sum(POSITIONS.AMOUNT).desc()).limit(10).fetch()
    }

    public List<OrganizationWithPrice> OrganizationsWherePriceOfGoodsGreaterThanValue(int value) throws SQLException {
    }

    public List<DataAmountPrice> AmountAndPricePerPeriodEveryDay(@NotNull String date1, @NotNull String date2) throws SQLException {

    }

    public String AvgPricePerPeriod(@NotNull String date1, @NotNull String date2) throws SQLException {
    }

    public List<OrganizationWithGoods> organizationsWithGoodsPerPeriod(@NotNull String date1, @NotNull String date2) throws SQLException {

    }

}
