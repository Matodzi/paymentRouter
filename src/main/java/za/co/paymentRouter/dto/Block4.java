package za.co.paymentRouter.dto;

public class Block4 {

    private String sendersReference;
    private String relatedReference;
    private String messageIndex;
    private OrderingCustomer orderingCustomer;
    private String requestedExecutionDate;
    private RepetitiveSequence repetitiveSequence;
    private String queries;
    private String narrativeDescription;

    public String getNarrativeDescription() {
        return narrativeDescription;
    }

    public void setNarrativeDescription(String narrativeDescription) {
        this.narrativeDescription = narrativeDescription;
    }

    public String getRelatedReference() {
        return relatedReference;
    }

    public void setRelatedReference(String relatedReference) {
        this.relatedReference = relatedReference;
    }

    public String getQueries() {
        return queries;
    }

    public void setQueries(String queries) {
        this.queries = queries;
    }

    public String getSendersReference() {
        return sendersReference;
    }

    public void setSendersReference(String sendersReference) {
        this.sendersReference = sendersReference;
    }

    public String getMessageIndex() {
        return messageIndex;
    }

    public void setMessageIndex(String messageIndex) {
        this.messageIndex = messageIndex;
    }

    public OrderingCustomer getOrderingCustomer() {
        return orderingCustomer;
    }

    public void setOrderingCustomer(OrderingCustomer orderingCustomer) {
        this.orderingCustomer = orderingCustomer;
    }

    public String getRequestedExecutionDate() {
        return requestedExecutionDate;
    }

    public void setRequestedExecutionDate(String requestedExecutionDate) {
        this.requestedExecutionDate = requestedExecutionDate;
    }

    public RepetitiveSequence getRepetitiveSequence() {
        return repetitiveSequence;
    }

    public void setRepetitiveSequence(RepetitiveSequence repetitiveSequence) {
        this.repetitiveSequence = repetitiveSequence;
    }
}
