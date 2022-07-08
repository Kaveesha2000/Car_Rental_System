package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
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
}
