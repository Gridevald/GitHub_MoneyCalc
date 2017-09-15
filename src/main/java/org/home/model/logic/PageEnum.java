package org.home.model.logic;

public enum PageEnum {
    HOME("/jsp/page/home.jsp"),
    LOGIN("/jsp/page/login.jsp"),
    SIGN("/jsp/page/sign.jsp"),
    MAIN("/jsp/page/main.jsp"),
    HELP("/jsp/page/help.jsp"),
    CONTACTS("/jsp/page/contacts.jsp");

    private String value;

    PageEnum(String value) {
        setValue(value);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
