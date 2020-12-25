package org.corda.model;


public class BagsToken {

    // literals
    public static final String BAGS_LITERAL = "bags";
    public static final String BAGS_COMMA_LITERAL = "bags,";
    public static final String BAG_LITERAL = "bags";
    public static final String BAG_COMMA_LITERAL = "bag,";
    public static final String BAG_END_LITERAL = "bag.";
    public static final String BAGS_END_LITERAL = "bags.";
    public static final String CONTAIN_LITERAL = "contain";
    public static final String NO_LITERAL = "no";


    // types
    public static final String NUMBER = "NUMBER";
    public static final String BAG = "BAG";

    private String type;
    private String value;
    private boolean main;

    public BagsToken(String type, String value) {
        this.type = type;
        this.value = value;
        this.main = false;
    }

    @Override
    public String toString() {
        return "(" +
            "type:'" + type + '\'' +
            ", value:'" + value + '\'' +
            ", main:'" + main + '\'' +
            ')';
    }

    public boolean isMain() {

        return main;
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public BagsToken(String type) {
        this( type, null );
    }

    public void setAsMain() {
        this.main = true;
    }

    public boolean isBag() {
        return BAG.equals( this.type );
    }
}
