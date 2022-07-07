package lk.ijse.spring.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Driver {

    @Id
    private
    String driverId;
    private String driverName;
    private String driverAddress;
    private String driverContact;
    private String driverNIC;
    private String driverLicenseNo;
    private String driverPassword;

    public Driver() {
    }

    public Driver(String driverId, String driverName, String driverAddress, String driverContact, String driverNIC, String driverLicenseNo, String driverPassword) {
        this.setDriverId(driverId);
        this.setDriverName(driverName);
        this.setDriverAddress(driverAddress);
        this.setDriverContact(driverContact);
        this.setDriverNIC(driverNIC);
        this.setDriverLicenseNo(driverLicenseNo);
        this.setDriverPassword(driverPassword);
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverAddress() {
        return driverAddress;
    }

    public void setDriverAddress(String driverAddress) {
        this.driverAddress = driverAddress;
    }

    public String getDriverContact() {
        return driverContact;
    }

    public void setDriverContact(String driverContact) {
        this.driverContact = driverContact;
    }

    public String getDriverNIC() {
        return driverNIC;
    }

    public void setDriverNIC(String driverNIC) {
        this.driverNIC = driverNIC;
    }

    public String getDriverLicenseNo() {
        return driverLicenseNo;
    }

    public void setDriverLicenseNo(String driverLicenseNo) {
        this.driverLicenseNo = driverLicenseNo;
    }

    public String getDriverPassword() {
        return driverPassword;
    }

    public void setDriverPassword(String driverPassword) {
        this.driverPassword = driverPassword;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "driverId='" + driverId + '\'' +
                ", driverName='" + driverName + '\'' +
                ", driverAddress='" + driverAddress + '\'' +
                ", driverContact='" + driverContact + '\'' +
                ", driverNIC='" + driverNIC + '\'' +
                ", driverLicenseNo='" + driverLicenseNo + '\'' +
                ", driverPassword='" + driverPassword + '\'' +
                '}';
    }
}
