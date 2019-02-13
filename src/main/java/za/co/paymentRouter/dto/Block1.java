package za.co.paymentRouter.dto;

public class Block1 {

    private String applicationId;
    private String serviceId;
    private String logicalTerminal;
    private String sessionNumber;
    private String sequenceNumber;

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getLogicalTerminal() {
        return logicalTerminal;
    }

    public void setLogicalTerminal(String logicalTerminal) {
        this.logicalTerminal = logicalTerminal;
    }

    public String getSessionNumber() {
        return sessionNumber;
    }

    public void setSessionNumber(String sessionNumber) {
        this.sessionNumber = sessionNumber;
    }

    public String getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(String sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }
}
