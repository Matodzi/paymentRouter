package za.co.paymentRouter.dto;

public class RepetitiveSequence {

    private String transactionReference;
    private String transactionAmount;
    private String industryParty;
    private Beneficiary beneficiary;
    private String detailsOfCharge;

    public String getTransactionReference() {
        return transactionReference;
    }

    public void setTransactionReference(String transactionReference) {
        this.transactionReference = transactionReference;
    }

    public String getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(String transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getIndustryParty() {
        return industryParty;
    }

    public void setIndustryParty(String industryParty) {
        this.industryParty = industryParty;
    }

    public Beneficiary getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(Beneficiary beneficiary) {
        this.beneficiary = beneficiary;
    }

    public String getDetailsOfCharge() {
        return detailsOfCharge;
    }

    public void setDetailsOfCharge(String detailsOfCharge) {
        this.detailsOfCharge = detailsOfCharge;
    }
}
