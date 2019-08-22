import QueryEntities.OrganizationWithAmount;
import QueryEntities.OrganizationWithPrice;
import org.jetbrains.annotations.NotNull;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Record5;
import org.jooq.Result;

import java.math.BigDecimal;
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

    @NotNull
    public List<OrganizationWithAmount> top10OrganizationsByAmountOfGoods() {
        List<OrganizationWithAmount> list = new LinkedList<>();
        final Result<Record5<Long, String, Long, Long, BigDecimal>> result = dslContext.select(ORGANIZATIONS.ID, ORGANIZATIONS.NAME, ORGANIZATIONS.INN,
                ORGANIZATIONS.SETTLEMENT_ACC, sum(POSITIONS.AMOUNT))
                .from(ORGANIZATIONS)
                .join(WAYBILLS).on(ORGANIZATIONS.ID.eq(WAYBILLS.ORG_SEND_ID))
                .join(POSITIONS).on(WAYBILLS.ORG_SEND_ID.eq(POSITIONS.WAYBILL_ID))
                .groupBy(ORGANIZATIONS.ID).orderBy(sum(POSITIONS.AMOUNT).desc()).limit(10).fetch();

        for (Record r : result) {
            long id = r.getValue(ORGANIZATIONS.ID);
            String name = r.getValue(ORGANIZATIONS.NAME);
            long inn = r.getValue(ORGANIZATIONS.INN);
            long settlementAcc = r.getValue(ORGANIZATIONS.SETTLEMENT_ACC);
            long amount = r.getValue(sum(POSITIONS.AMOUNT)).longValue();
            list.add(new OrganizationWithAmount(id, name, inn, settlementAcc, amount));
        }
        return list;
    }

    @NotNull
    public List<OrganizationWithPrice> OrganizationsWherePriceOfGoodsGreaterThanValue(long value) {
        List<OrganizationWithPrice> list = new LinkedList<>();
        final Result<Record5<Long, String, Long, Long, Long>> result = dslContext.select(ORGANIZATIONS.ID, ORGANIZATIONS.NAME,
                ORGANIZATIONS.INN, ORGANIZATIONS.SETTLEMENT_ACC, POSITIONS.PRICE)
                .from(ORGANIZATIONS)
                .join(WAYBILLS).on(ORGANIZATIONS.ID.eq(WAYBILLS.ORG_SEND_ID))
                .join(POSITIONS).on(WAYBILLS.ORG_SEND_ID.eq(POSITIONS.WAYBILL_ID))
                .groupBy(ORGANIZATIONS.ID, POSITIONS.PRICE)
                .having(POSITIONS.PRICE.greaterThan(value)).orderBy(ORGANIZATIONS.ID.asc()).fetch();

        for (Record r : result) {
            long id = r.getValue(ORGANIZATIONS.ID);
            String name = r.getValue(ORGANIZATIONS.NAME);
            long inn = r.getValue(ORGANIZATIONS.INN);
            long settlementAcc = r.getValue(ORGANIZATIONS.SETTLEMENT_ACC);
            long price = r.getValue(POSITIONS.PRICE);
            list.add(new OrganizationWithPrice(id, name, inn, settlementAcc, price));
        }
        return list;
    }

//    public List<DataAmountPrice> AmountAndPricePerPeriodEveryDay(@NotNull String date1, @NotNull String date2) throws ParseException {
//        List<DataAmountPrice> list = new LinkedList<>();
//        Date date = new Date(0000,00,00);
//        final Result<Record> result = dslContext.select(WAYBILLS.DATE, sum(POSITIONS.AMOUNT), sum(POSITIONS.PRICE))
//                .from(ORGANIZATIONS)
//                .join(WAYBILLS).on(ORGANIZATIONS.ID.eq(WAYBILLS.ORG_SEND_ID))
//                .join(POSITIONS).on(WAYBILLS.ORG_SEND_ID.eq(POSITIONS.WAYBILL_ID))
//                .where(WAYBILLS.DATE.between(date(date1), date(date2))).groupBy(WAYBILLS.DATE)
//                .union(
//                        select(, sum(POSITIONS.AMOUNT), sum(POSITIONS.PRICE))
//                                .from(ORGANIZATIONS)
//                                .join(WAYBILLS).on(ORGANIZATIONS.ID.eq(WAYBILLS.ORG_SEND_ID))
//                                .join(POSITIONS).on(WAYBILLS.ORG_SEND_ID.eq(POSITIONS.WAYBILL_ID))
//                                .where(WAYBILLS.DATE.between(date(date1), date(date2)))
//                                .groupBy(WAYBILLS.DATE)
//                                .orderBy(WAYBILLS.DATE.asc())
//                ).fetch();
//        for (Record r : result) {
//            Date date = r.getValue(WAYBILLS.DATE);
//            long amount = r.getValue(sum(POSITIONS.AMOUNT)).longValue();
//            long price = r.getValue(sum(POSITIONS.PRICE)).longValue();
//            list.add(new DataAmountPrice(date, amount, price));
//        }
//        return list;
//    }

//    public String AvgPricePerPeriod(@NotNull String date1, @NotNull String date2) {
//    }
//
//    public List<OrganizationWithGoods> organizationsWithGoodsPerPeriod(@NotNull String date1, @NotNull String date2)  {
//
//    }

}
