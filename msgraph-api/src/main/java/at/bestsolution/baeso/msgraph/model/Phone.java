package at.bestsolution.baeso.msgraph.model;

import at.bestsolution.baeso.msgraph.base.MsGraphData;

public interface Phone extends MsGraphData {
    public enum PhoneType {
        HOME("home"), 
        BUSINESS("business"), 
        MOBILE("mobile"), 
        OTHER("other"), 
        ASSISTANT("assistant"), 
        HOME_FAX("homeFax"), 
        BUSINESS_FAX("businessFax"), 
        OTHER_FAX("otherFax"), 
        PAGER("pager"), 
        RADIO("radio");

        private final String value;

        PhoneType(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }

        public static PhoneType of(String value) {
            return switch(value) {
                case "home" -> HOME;
                case "business" -> BUSINESS;
                case "mobile" -> MOBILE;
                case "other" -> OTHER;
                case "assistant" -> ASSISTANT;
                case "homeFax" -> HOME_FAX;
                case "businessFax" -> BUSINESS_FAX;
                case "otherFax" -> OTHER_FAX;
                case "pager" -> PAGER;
                case "radio" -> RADIO;
                default -> throw new IllegalArgumentException(String.format("Unknown value '%s'", value));
            };
        }
    }

    String number();
    PhoneType type();
}
