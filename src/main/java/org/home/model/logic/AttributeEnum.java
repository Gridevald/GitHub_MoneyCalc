package org.home.model.logic;

public enum AttributeEnum {
    LOG("log"),
    STATUS("status"),
    EMAIL("user_email"),
    ORDER_LIST("order_list");

    String value;

    AttributeEnum(String value) {
        setValue(value);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
