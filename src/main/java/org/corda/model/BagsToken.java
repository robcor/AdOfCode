package org.corda.model;


public class BagsToken {

    String type;
    String value;

    public BagsToken(String type, String value) {
        this.type = type;
        this.value = value;
    }

    @Override
    public String toString() {
        return "(" +
            "type:'" + type + '\'' +
            ", value:'" + value + '\'' +
            ')';
    }

    public BagsToken(String type) {
        this( type, null );
    }
}
