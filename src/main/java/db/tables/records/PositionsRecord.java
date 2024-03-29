/*
 * This file is generated by jOOQ.
 */
package db.tables.records;


import db.tables.Positions;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.11"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class PositionsRecord extends UpdatableRecordImpl<PositionsRecord> implements Record4<Long, Long, Long, Long> {

    private static final long serialVersionUID = 1014629092;

    /**
     * Setter for <code>public.positions.nomenclature_id</code>.
     */
    public PositionsRecord setNomenclatureId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.positions.nomenclature_id</code>.
     */
    public Long getNomenclatureId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.positions.waybill_id</code>.
     */
    public PositionsRecord setWaybillId(Long value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.positions.waybill_id</code>.
     */
    public Long getWaybillId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>public.positions.price</code>.
     */
    public PositionsRecord setPrice(Long value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.positions.price</code>.
     */
    public Long getPrice() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>public.positions.amount</code>.
     */
    public PositionsRecord setAmount(Long value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.positions.amount</code>.
     */
    public Long getAmount() {
        return (Long) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Long, Long, Long, Long> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Long, Long, Long, Long> valuesRow() {
        return (Row4) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return Positions.POSITIONS.NOMENCLATURE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field2() {
        return Positions.POSITIONS.WAYBILL_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field3() {
        return Positions.POSITIONS.PRICE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field4() {
        return Positions.POSITIONS.AMOUNT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component1() {
        return getNomenclatureId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component2() {
        return getWaybillId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component3() {
        return getPrice();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component4() {
        return getAmount();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getNomenclatureId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value2() {
        return getWaybillId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value3() {
        return getPrice();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value4() {
        return getAmount();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PositionsRecord value1(Long value) {
        setNomenclatureId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PositionsRecord value2(Long value) {
        setWaybillId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PositionsRecord value3(Long value) {
        setPrice(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PositionsRecord value4(Long value) {
        setAmount(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PositionsRecord values(Long value1, Long value2, Long value3, Long value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached PositionsRecord
     */
    public PositionsRecord() {
        super(Positions.POSITIONS);
    }

    /**
     * Create a detached, initialised PositionsRecord
     */
    public PositionsRecord(Long nomenclatureId, Long waybillId, Long price, Long amount) {
        super(Positions.POSITIONS);

        set(0, nomenclatureId);
        set(1, waybillId);
        set(2, price);
        set(3, amount);
    }
}
