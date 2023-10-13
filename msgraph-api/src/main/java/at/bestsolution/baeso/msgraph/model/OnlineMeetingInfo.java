package at.bestsolution.baeso.msgraph.model;

import java.util.List;
import java.util.function.Function;

import at.bestsolution.baeso.msgraph.base.IndexBuilderFunction;
import at.bestsolution.baeso.msgraph.base.MsGraphData;

/**
 * Details for an attendee to join the meeting online.
 */
public interface OnlineMeetingInfo extends MsGraphData {
    /**
     * The ID of the conference.
     * 
     * @return the value
     */
    String conferenceId();

    /**
     * The external link that launches the online meeting. This is a URL that
     * clients launch into a browser and will redirect the user to join the meeting.
     * 
     * @return the value
     */
    String joinUrl();

    /**
     * All of the phone numbers associated with this conference.
     * 
     * @return the value
     */
    List<Phone> phones();

    /**
     * The preformatted quick dial for this call.
     * 
     * @return the value
     */
    String quickDial();

    /**
     * The toll free numbers that can be used to join the conference.
     * 
     * @return the value
     */
    List<String> tollFreeNumbers();

    /**
     * The toll number that can be used to join the conference.
     * 
     * @return the value
     */
    String tollNumber();

    public interface Builder {
        Builder conferenceId(String conferenceId);

        Builder joinUrl(String joinUrl);

        Builder phones(List<Phone> phones);
        <T> Builder withPhones(List<T> source, Function<Phone.Builder, Phone> builder);
        Builder withPhones(int count, IndexBuilderFunction<Phone.Builder, Phone> builder);

        Builder quickDial(String quickDial);

        Builder tollFreeNumbers(List<String> tollFreeNumbers);

        Builder tollNumber(String tollNumber);
    }
}
