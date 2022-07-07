package lk.ijse.spring.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Rent {

    @Id
    private
    String paymentId;
    private double rentFee;
    private double extraKm;
    private double extraKmFee;
    private double driverFee;
    private double fullPayment;
    private String rentDate;
    private double reducedLossDamagedWaiverPayment;
    private double lossDamagedWaiverPayment;

    public Rent() {
    }

    public Rent(String paymentId, double rentFee, double extraKm, double extraKmFee, double driverFee, double fullPayment, String rentDate, double reducedLossDamagedWaiverPayment, double lossDamagedWaiverPayment) {
        this.setPaymentId(paymentId);
        this.setRentFee(rentFee);
        this.setExtraKm(extraKm);
        this.setExtraKmFee(extraKmFee);
        this.setDriverFee(driverFee);
        this.setFullPayment(fullPayment);
        this.setRentDate(rentDate);
        this.setReducedLossDamagedWaiverPayment(reducedLossDamagedWaiverPayment);
        this.setLossDamagedWaiverPayment(lossDamagedWaiverPayment);
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public double getRentFee() {
        return rentFee;
    }

    public void setRentFee(double rentFee) {
        this.rentFee = rentFee;
    }

    public double getExtraKm() {
        return extraKm;
    }

    public void setExtraKm(double extraKm) {
        this.extraKm = extraKm;
    }

    public double getExtraKmFee() {
        return extraKmFee;
    }

    public void setExtraKmFee(double extraKmFee) {
        this.extraKmFee = extraKmFee;
    }

    public double getDriverFee() {
        return driverFee;
    }

    public void setDriverFee(double driverFee) {
        this.driverFee = driverFee;
    }

    public double getFullPayment() {
        return fullPayment;
    }

    public void setFullPayment(double fullPayment) {
        this.fullPayment = fullPayment;
    }

    public String getRentDate() {
        return rentDate;
    }

    public void setRentDate(String rentDate) {
        this.rentDate = rentDate;
    }

    public double getReducedLossDamagedWaiverPayment() {
        return reducedLossDamagedWaiverPayment;
    }

    public void setReducedLossDamagedWaiverPayment(double reducedLossDamagedWaiverPayment) {
        this.reducedLossDamagedWaiverPayment = reducedLossDamagedWaiverPayment;
    }

    public double getLossDamagedWaiverPayment() {
        return lossDamagedWaiverPayment;
    }

    public void setLossDamagedWaiverPayment(double lossDamagedWaiverPayment) {
        this.lossDamagedWaiverPayment = lossDamagedWaiverPayment;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "paymentId='" + paymentId + '\'' +
                ", rentFee=" + rentFee +
                ", extraKm=" + extraKm +
                ", extraKmFee=" + extraKmFee +
                ", driverFee=" + driverFee +
                ", fullPayment=" + fullPayment +
                ", rentDate='" + rentDate + '\'' +
                ", reducedLossDamagedWaiverPayment=" + reducedLossDamagedWaiverPayment +
                ", lossDamagedWaiverPayment=" + lossDamagedWaiverPayment +
                '}';
    }
}
