/*
 * This file is generated by jOOQ.
 */
package db.tables.pojos;


import java.io.Serializable;
import java.sql.Timestamp;

import javax.annotation.Generated;


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
public class FlywaySchemaHistory implements Serializable {

    private static final long serialVersionUID = -1348959368;

    private final Integer   installedRank;
    private final String    version;
    private final String    description;
    private final String    type;
    private final String    script;
    private final Integer   checksum;
    private final String    installedBy;
    private final Timestamp installedOn;
    private final Integer   executionTime;
    private final Boolean   success;

    public FlywaySchemaHistory(FlywaySchemaHistory value) {
        this.installedRank = value.installedRank;
        this.version = value.version;
        this.description = value.description;
        this.type = value.type;
        this.script = value.script;
        this.checksum = value.checksum;
        this.installedBy = value.installedBy;
        this.installedOn = value.installedOn;
        this.executionTime = value.executionTime;
        this.success = value.success;
    }

    public FlywaySchemaHistory(
        Integer   installedRank,
        String    version,
        String    description,
        String    type,
        String    script,
        Integer   checksum,
        String    installedBy,
        Timestamp installedOn,
        Integer   executionTime,
        Boolean   success
    ) {
        this.installedRank = installedRank;
        this.version = version;
        this.description = description;
        this.type = type;
        this.script = script;
        this.checksum = checksum;
        this.installedBy = installedBy;
        this.installedOn = installedOn;
        this.executionTime = executionTime;
        this.success = success;
    }

    public Integer getInstalledRank() {
        return this.installedRank;
    }

    public String getVersion() {
        return this.version;
    }

    public String getDescription() {
        return this.description;
    }

    public String getType() {
        return this.type;
    }

    public String getScript() {
        return this.script;
    }

    public Integer getChecksum() {
        return this.checksum;
    }

    public String getInstalledBy() {
        return this.installedBy;
    }

    public Timestamp getInstalledOn() {
        return this.installedOn;
    }

    public Integer getExecutionTime() {
        return this.executionTime;
    }

    public Boolean getSuccess() {
        return this.success;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("FlywaySchemaHistory (");

        sb.append(installedRank);
        sb.append(", ").append(version);
        sb.append(", ").append(description);
        sb.append(", ").append(type);
        sb.append(", ").append(script);
        sb.append(", ").append(checksum);
        sb.append(", ").append(installedBy);
        sb.append(", ").append(installedOn);
        sb.append(", ").append(executionTime);
        sb.append(", ").append(success);

        sb.append(")");
        return sb.toString();
    }
}
