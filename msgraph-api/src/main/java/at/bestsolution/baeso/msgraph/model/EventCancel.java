package at.bestsolution.baeso.msgraph.model;

public interface EventCancel {
    /**
     * A comment about the cancellation sent to all the attendees. Optional.
     * @return value
     */
    String comment();

    public interface Builder {
        public EventCancel build();
        Builder comment(String comment);
    }
}
