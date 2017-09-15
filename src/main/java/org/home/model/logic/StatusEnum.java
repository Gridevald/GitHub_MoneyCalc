package org.home.model.logic;

public enum StatusEnum {
    GUEST("guest"), USER("user");

    private String value;

    StatusEnum(String value) {
        setValue(value);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
