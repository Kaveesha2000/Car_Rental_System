package lk.ijse.spring.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Schedule {

    @Id
    private
    String scheduleId;
    private String driverId;
    private String carId;
    private String pickedDate;
    private String pickedTime;
    private String returnDate;
    private String releasedOrNot;

    public Schedule() {
    }

    public Schedule(String scheduleId, String driverId, String carId, String pickedDate, String pickedTime, String returnDate, String releasedOrNot) {
        this.setScheduleId(scheduleId);
        this.setDriverId(driverId);
        this.setCarId(carId);
        this.setPickedDate(pickedDate);
        this.setPickedTime(pickedTime);
        this.setReturnDate(returnDate);
        this.setReleasedOrNot(releasedOrNot);
    }

    public String getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
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

    public String getReleasedOrNot() {
        return releasedOrNot;
    }

    public void setReleasedOrNot(String releasedOrNot) {
        this.releasedOrNot = releasedOrNot;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "scheduleId='" + scheduleId + '\'' +
                ", driverId='" + driverId + '\'' +
                ", carId='" + carId + '\'' +
                ", pickedDate='" + pickedDate + '\'' +
                ", pickedTime='" + pickedTime + '\'' +
                ", returnDate='" + returnDate + '\'' +
                ", releasedOrNot='" + releasedOrNot + '\'' +
                '}';
    }
}
