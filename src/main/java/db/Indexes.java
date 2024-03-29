/*
 * This file is generated by jOOQ.
 */
package db;


import db.tables.FlywaySchemaHistory;
import db.tables.Nomenclature;
import db.tables.Organizations;
import db.tables.Positions;
import db.tables.Waybills;

import javax.annotation.Generated;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables of the <code>public</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.11"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index FLYWAY_SCHEMA_HISTORY_PK = Indexes0.FLYWAY_SCHEMA_HISTORY_PK;
    public static final Index FLYWAY_SCHEMA_HISTORY_S_IDX = Indexes0.FLYWAY_SCHEMA_HISTORY_S_IDX;
    public static final Index NOMENCLATURE_PK = Indexes0.NOMENCLATURE_PK;
    public static final Index ORGANIZATIONS_PK = Indexes0.ORGANIZATIONS_PK;
    public static final Index POSITIONS_PK = Indexes0.POSITIONS_PK;
    public static final Index WAYBILLS_PK = Indexes0.WAYBILLS_PK;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index FLYWAY_SCHEMA_HISTORY_PK = Internal.createIndex("flyway_schema_history_pk", FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY, new OrderField[] { FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.INSTALLED_RANK }, true);
        public static Index FLYWAY_SCHEMA_HISTORY_S_IDX = Internal.createIndex("flyway_schema_history_s_idx", FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY, new OrderField[] { FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.SUCCESS }, false);
        public static Index NOMENCLATURE_PK = Internal.createIndex("nomenclature_pk", Nomenclature.NOMENCLATURE, new OrderField[] { Nomenclature.NOMENCLATURE.ID }, true);
        public static Index ORGANIZATIONS_PK = Internal.createIndex("organizations_pk", Organizations.ORGANIZATIONS, new OrderField[] { Organizations.ORGANIZATIONS.ID }, true);
        public static Index POSITIONS_PK = Internal.createIndex("positions_pk", Positions.POSITIONS, new OrderField[] { Positions.POSITIONS.NOMENCLATURE_ID }, true);
        public static Index WAYBILLS_PK = Internal.createIndex("waybills_pk", Waybills.WAYBILLS, new OrderField[] { Waybills.WAYBILLS.ORG_SEND_ID }, true);
    }
}
