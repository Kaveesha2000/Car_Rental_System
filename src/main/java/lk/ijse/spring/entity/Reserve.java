package lk.ijse.spring.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Reserve {

    @Id
    private
    String reserveId;
    private String pickedDate;
    private String pickedTime;
    private String returnDate;
    private String returnTime;
    private String destination;
    private boolean driverWantOrNot;
    private String acceptOrDeny;

    public Reserve() {
    }

    public Reserve(String reserveId, String pickedDate, String pickedTime, String returnDate, String returnTime, String destination, boolean driverWantOrNot, String acceptOrDeny) {
        this.setReserveId(reserveId);
        this.setPickedDate(pickedDate);
        this.setPickedTime(pickedTime);
        this.setReturnDate(returnDate);
        this.setReturnTime(returnTime);
        this.setDestination(destination);
        this.setDriverWantOrNot(driverWantOrNot);
        this.setAcceptOrDeny(acceptOrDeny);
    }

    public String getReserveId() {
        return reserveId;
    }

    public void setReserveId(String reserveId) {
        this.reserveId = reserveId;
    }

    public String getPickedDate() {
        return pickedDate;
    }

    public void setPickedDate(String pickedDate) {
        this.pickedDate = pickedDate;
    }

    public String getPickedTime() {
        return pickedTime;
    }

    public void setPickedTime(String pickedTime) {
        this.pickedTime = pickedTime;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public boolean isDriverWantOrNot() {
        return driverWantOrNot;
    }

    public void setDriverWantOrNot(boolean driverWantOrNot) {
        this.driverWantOrNot = driverWantOrNot;
    }

    public String getAcceptOrDeny() {
        return acceptOrDeny;
    }

    public void setAcceptOrDeny(String acceptOrDeny) {
        this.acceptOrDeny = acceptOrDeny;
    }

    @Override
    public String toString() {
        return "Reserve{" +
                "reserveId='" + reserveId + '\'' +
                ", pickedDate='" + pickedDate + '\'' +
                ", pickedTime='" + pickedTime + '\'' +
                ", returnDate='" + returnDate + '\'' +
                ", returnTime='" + returnTime + '\'' +
                ", destination='" + destination + '\'' +
                ", driverWantOrNot=" + driverWantOrNot +
                ", acceptOrDeny='" + acceptOrDeny + '\'' +
                '}';
    }
}
