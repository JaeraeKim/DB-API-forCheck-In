package com.check_in.dto;

public class UserSiteInformationDTO {
    private String agentID;
    private String name;
    private String URL;
    private String ID;
    private String PW;

    public String getAgentID() {
        return agentID;
    }

    public String getName() {
        return name;
    }

    public String getURL() {
        return URL;
    }

    public String getID() {
        return ID;
    }

    public String getPW() {
        return PW;
    }

    public void setAgentID(String agentID) {
        this.agentID = agentID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setPW(String PW) {
        this.PW = PW;
    }
}
