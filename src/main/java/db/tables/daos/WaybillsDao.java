/*
 * This file is generated by jOOQ.
 */
package db.tables.daos;


import db.tables.Waybills;
import db.tables.records.WaybillsRecord;

import java.sql.Date;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


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
public class WaybillsDao extends DAOImpl<WaybillsRecord, db.tables.pojos.Waybills, Long> {

    /**
     * Create a new WaybillsDao without any configuration
     */
    public WaybillsDao() {
        super(Waybills.WAYBILLS, db.tables.pojos.Waybills.class);
    }

    /**
     * Create a new WaybillsDao with an attached configuration
     */
    public WaybillsDao(Configuration configuration) {
        super(Waybills.WAYBILLS, db.tables.pojos.Waybills.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Long getId(db.tables.pojos.Waybills object) {
        return object.getOrgSendId();
    }

    /**
     * Fetch records that have <code>org_send_id IN (values)</code>
     */
    public List<db.tables.pojos.Waybills> fetchByOrgSendId(Long... values) {
        return fetch(Waybills.WAYBILLS.ORG_SEND_ID, values);
    }

    /**
     * Fetch a unique record that has <code>org_send_id = value</code>
     */
    public db.tables.pojos.Waybills fetchOneByOrgSendId(Long value) {
        return fetchOne(Waybills.WAYBILLS.ORG_SEND_ID, value);
    }

    /**
     * Fetch records that have <code>number IN (values)</code>
     */
    public List<db.tables.pojos.Waybills> fetchByNumber(Long... values) {
        return fetch(Waybills.WAYBILLS.NUMBER, values);
    }

    /**
     * Fetch records that have <code>date IN (values)</code>
     */
    public List<db.tables.pojos.Waybills> fetchByDate(Date... values) {
        return fetch(Waybills.WAYBILLS.DATE, values);
    }
}
