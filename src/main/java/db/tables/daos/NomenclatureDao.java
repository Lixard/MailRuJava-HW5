/*
 * This file is generated by jOOQ.
 */
package db.tables.daos;


import db.tables.Nomenclature;
import db.tables.records.NomenclatureRecord;

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
public class NomenclatureDao extends DAOImpl<NomenclatureRecord, db.tables.pojos.Nomenclature, Long> {

    /**
     * Create a new NomenclatureDao without any configuration
     */
    public NomenclatureDao() {
        super(Nomenclature.NOMENCLATURE, db.tables.pojos.Nomenclature.class);
    }

    /**
     * Create a new NomenclatureDao with an attached configuration
     */
    public NomenclatureDao(Configuration configuration) {
        super(Nomenclature.NOMENCLATURE, db.tables.pojos.Nomenclature.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Long getId(db.tables.pojos.Nomenclature object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<db.tables.pojos.Nomenclature> fetchById(Long... values) {
        return fetch(Nomenclature.NOMENCLATURE.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public db.tables.pojos.Nomenclature fetchOneById(Long value) {
        return fetchOne(Nomenclature.NOMENCLATURE.ID, value);
    }

    /**
     * Fetch records that have <code>name IN (values)</code>
     */
    public List<db.tables.pojos.Nomenclature> fetchByName(String... values) {
        return fetch(Nomenclature.NOMENCLATURE.NAME, values);
    }

    /**
     * Fetch records that have <code>code IN (values)</code>
     */
    public List<db.tables.pojos.Nomenclature> fetchByCode(Long... values) {
        return fetch(Nomenclature.NOMENCLATURE.CODE, values);
    }
}