package com.check_in.dto;

public class AgentAccountDTO {
    private String agentID;
    private String agentPW;
    private String name;
    private int errorCount;
    private int numberOfDevice;

    public AgentAccountDTO (String agentID, String agentPW, String name, int errorCount, int numberOfDevice) {
        this.agentID = agentID;
        this.agentPW = agentPW;
        this.name = name;
        this.errorCount = errorCount;
        this.numberOfDevice = numberOfDevice;
    }

    public AgentAccountDTO () {}

    public String toString() {
        return agentID  + "|" + agentPW + "|" + name + "|" + errorCount + "|" + numberOfDevice;
    }

    public String getAgentID() {
        return agentID;
    }

    public String getAgentPW() {
        return agentPW;
    }

    public String getName() {
        return name;
    }

    public int getErrorCount() {
        return errorCount;
    }

    public int getNumberOfDevice() {
        return numberOfDevice;
    }

    public void setAgentID(String agentID) {
        this.agentID = agentID;
    }

    public void setAgentPW(String agentPW) {
        this.agentPW = agentPW;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setErrorCount(int errorCount) {
        this.errorCount = errorCount;
    }

    public void setNumberOfDevice(int numberOfDevice) {
        this.numberOfDevice = numberOfDevice;
    }
}
