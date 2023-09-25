package at.bestsolution.baeso.msgraph.model;

import java.util.List;

import at.bestsolution.baeso.msgraph.base.MsGraphData;

public interface OnlineMeetingInfo extends MsGraphData {
    String conferenceId();
    String joinUrl();
    List<Phone> phones();
    String quickDial();
    List<String> tollFreeNumbers();
    String tollNumber();
}
