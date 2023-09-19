package at.bestsolution.baeso.msgraph.model;

public interface AttendeeBase extends Recipient {
    public enum Type {
        REQUIRED("required"),
        OPTIONAL("optional"),
        RESOURCE("resource");

        private final String value;

        Type(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }

        public static Type of(String value) {
            return switch(value) {
                case "required" -> REQUIRED;
                case "optional" -> OPTIONAL;
                case "resource" -> RESOURCE;
                default -> throw new IllegalArgumentException(String.format("Unknown value '%s'", value));
            };
        }
    }

    Type type();
    EmailAddress emailAddress();

}
