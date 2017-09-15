package org.home.model.logic;

public enum LogEnum {
    LOGIN("Log In"), LOGOUT("Log Out");

    private String value;

    LogEnum(String value) {
        setValue(value);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
