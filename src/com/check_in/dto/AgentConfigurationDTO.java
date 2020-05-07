package com.check_in.dto;

public class AgentConfigurationDTO {
    private String agentID;
    private String browserPreference;

    public String getAgentID() {
        return agentID;
    }

    public void setAgentID(String agentID) {
        this.agentID = agentID;
    }

    public String getBrowserPreference() {
        return browserPreference;
    }

    public void setBrowserPreference(String browserPreference) {
        this.browserPreference = browserPreference;
    }
}
