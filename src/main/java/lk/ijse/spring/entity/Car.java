package lk.ijse.spring.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Car {

    @Id
    private String carId;
    private String registerNo;
    private String transmissionType;
    private String color;
    private String type;
    private String brand;
    private String fuelType;
    private double price;
    private int noOfPassengers;
    private double wholeKm;
    private double extraOneKmFee;
    private double dailyRatePrice;
    private double monthlyRatePrice;
    private String availableOrNot;
    private boolean underMaintainanceOrNot;
    private String frontView;
    private String backView;
    private String sideView;
    private String interiorView;

    public Car() {
    }

    public Car(String carId, String registerNo, String transmissionType, String color, String type, String brand, String fuelType, double price, int noOfPassengers, double wholeKm, double extraOneKmFee, double dailyRatePrice, double monthlyRatePrice, String availableOrNot, boolean underMaintainanceOrNot, String frontView, String backView, String sideView, String interiorView) {
        this.setCarId(carId);
        this.setRegisterNo(registerNo);
        this.setTransmissionType(transmissionType);
        this.setColor(color);
        this.setType(type);
        this.setBrand(brand);
        this.setFuelType(fuelType);
        this.setPrice(price);
        this.setNoOfPassengers(noOfPassengers);
        this.setWholeKm(wholeKm);
        this.setExtraOneKmFee(extraOneKmFee);
        this.setDailyRatePrice(dailyRatePrice);
        this.setMonthlyRatePrice(monthlyRatePrice);
        this.setAvailableOrNot(availableOrNot);
        this.setUnderMaintainanceOrNot(underMaintainanceOrNot);
        this.setFrontView(frontView);
        this.setBackView(backView);
        this.setSideView(sideView);
        this.setInteriorView(interiorView);
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getRegisterNo() {
        return registerNo;
    }

    public void setRegisterNo(String registerNo) {
        this.registerNo = registerNo;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNoOfPassengers() {
        return noOfPassengers;
    }

    public void setNoOfPassengers(int noOfPassengers) {
        this.noOfPassengers = noOfPassengers;
    }

    public double getWholeKm() {
        return wholeKm;
    }

    public void setWholeKm(double wholeKm) {
        this.wholeKm = wholeKm;
    }

    public double getExtraOneKmFee() {
        return extraOneKmFee;
    }

    public void setExtraOneKmFee(double extraOneKmFee) {
        this.extraOneKmFee = extraOneKmFee;
    }

    public double getDailyRatePrice() {
        return dailyRatePrice;
    }

    public void setDailyRatePrice(double dailyRatePrice) {
        this.dailyRatePrice = dailyRatePrice;
    }

    public double getMonthlyRatePrice() {
        return monthlyRatePrice;
    }

    public void setMonthlyRatePrice(double monthlyRatePrice) {
        this.monthlyRatePrice = monthlyRatePrice;
    }

    public String getAvailableOrNot() {
        return availableOrNot;
    }

    public void setAvailableOrNot(String availableOrNot) {
        this.availableOrNot = availableOrNot;
    }

    public boolean isUnderMaintainanceOrNot() {
        return underMaintainanceOrNot;
    }

    public void setUnderMaintainanceOrNot(boolean underMaintainanceOrNot) {
        this.underMaintainanceOrNot = underMaintainanceOrNot;
    }

    public String getFrontView() {
        return frontView;
    }

    public void setFrontView(String frontView) {
        this.frontView = frontView;
    }

    public String getBackView() {
        return backView;
    }

    public void setBackView(String backView) {
        this.backView = backView;
    }

    public String getSideView() {
        return sideView;
    }

    public void setSideView(String sideView) {
        this.sideView = sideView;
    }

    public String getInteriorView() {
        return interiorView;
    }

    public void setInteriorView(String interiorView) {
        this.interiorView = interiorView;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId='" + carId + '\'' +
                ", registerNo='" + registerNo + '\'' +
                ", transmissionType='" + transmissionType + '\'' +
                ", color='" + color + '\'' +
                ", type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", price=" + price +
                ", noOfPassengers=" + noOfPassengers +
                ", wholeKm=" + wholeKm +
                ", extraOneKmFee=" + extraOneKmFee +
                ", dailyRatePrice=" + dailyRatePrice +
                ", monthlyRatePrice=" + monthlyRatePrice +
                ", availableOrNot='" + availableOrNot + '\'' +
                ", underMaintainanceOrNot=" + underMaintainanceOrNot +
                ", frontView='" + frontView + '\'' +
                ", backView='" + backView + '\'' +
                ", sideView='" + sideView + '\'' +
                ", interiorView='" + interiorView + '\'' +
                '}';
    }
}
