public class IrregReservation extends Reservation {
    private String reason;
    private boolean isApproved;

    public IrregReservation() {
        super();
    }

    // Getters and setters
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean isApproved) {
        this.isApproved = isApproved;
    }

    @Override
    public String toString() {
        return "IrregReservation{" +
                "reason='" + reason + '\'' +
                ", isApproved=" + isApproved +
                ", " + super.toString() +
                '}';
    }
}
