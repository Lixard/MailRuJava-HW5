/*
 * This file is generated by jOOQ.
 */
package db.tables.pojos;


import java.io.Serializable;

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
public class Nomenclature implements Serializable {

    private static final long serialVersionUID = 705862303;

    private final Long   id;
    private final String name;
    private final Long   code;

    public Nomenclature(Nomenclature value) {
        this.id = value.id;
        this.name = value.name;
        this.code = value.code;
    }

    public Nomenclature(
        Long   id,
        String name,
        Long   code
    ) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Long getCode() {
        return this.code;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Nomenclature (");

        sb.append(id);
        sb.append(", ").append(name);
        sb.append(", ").append(code);

        sb.append(")");
        return sb.toString();
    }
}
