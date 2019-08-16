/*
 * This file is generated by jOOQ.
 */
package db.tables;


import db.Indexes;
import db.Keys;
import db.Public;
import db.tables.records.WaybillsRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import javax.annotation.Generated;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;


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
public class Waybills extends TableImpl<WaybillsRecord> {

    private static final long serialVersionUID = 1204959017;

    /**
     * The reference instance of <code>public.waybills</code>
     */
    public static final Waybills WAYBILLS = new Waybills();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<WaybillsRecord> getRecordType() {
        return WaybillsRecord.class;
    }

    /**
     * The column <code>public.waybills.org_send_id</code>.
     */
    public final TableField<WaybillsRecord, Long> ORG_SEND_ID = createField("org_send_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.waybills.number</code>.
     */
    public final TableField<WaybillsRecord, Long> NUMBER = createField("number", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.waybills.date</code>.
     */
    public final TableField<WaybillsRecord, Date> DATE = createField("date", org.jooq.impl.SQLDataType.DATE.nullable(false), this, "");

    /**
     * Create a <code>public.waybills</code> table reference
     */
    public Waybills() {
        this(DSL.name("waybills"), null);
    }

    /**
     * Create an aliased <code>public.waybills</code> table reference
     */
    public Waybills(String alias) {
        this(DSL.name(alias), WAYBILLS);
    }

    /**
     * Create an aliased <code>public.waybills</code> table reference
     */
    public Waybills(Name alias) {
        this(alias, WAYBILLS);
    }

    private Waybills(Name alias, Table<WaybillsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Waybills(Name alias, Table<WaybillsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Waybills(Table<O> child, ForeignKey<O, WaybillsRecord> key) {
        super(child, key, WAYBILLS);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.WAYBILLS_PK);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<WaybillsRecord> getPrimaryKey() {
        return Keys.WAYBILLS_PK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<WaybillsRecord>> getKeys() {
        return Arrays.<UniqueKey<WaybillsRecord>>asList(Keys.WAYBILLS_PK);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<WaybillsRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<WaybillsRecord, ?>>asList(Keys.WAYBILLS__WAYBILLS_FK0);
    }

    public Organizations organizations() {
        return new Organizations(this, Keys.WAYBILLS__WAYBILLS_FK0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Waybills as(String alias) {
        return new Waybills(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Waybills as(Name alias) {
        return new Waybills(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Waybills rename(String name) {
        return new Waybills(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Waybills rename(Name name) {
        return new Waybills(name, null);
    }
}
