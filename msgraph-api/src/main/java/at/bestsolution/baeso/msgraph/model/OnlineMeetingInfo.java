package at.bestsolution.baeso.msgraph.model;

import java.util.List;

public interface OnlineMeetingInfo {
    String conferenceId();
    String joinUrl();
    List<Phone> phones();
    String quickDial();
    List<String> tollFreeNumbers();
    String tollNumber();
}
