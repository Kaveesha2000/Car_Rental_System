package lk.ijse.spring.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {

    @Id
    private
    String customerId;
    private String customerName;
    private String customerAddress;
    private String customerContact;
    private String customerNIC;
    private String customerLicenseNo;
    private String customerEmail;
    private String customerNewPassword;

    public Customer() {
    }

    public Customer(String customerId, String customerName, String customerAddress, String customerContact, String customerNIC, String customerLicenseNo, String customerEmail, String customerNewPassword) {
        this.setCustomerId(customerId);
        this.setCustomerName(customerName);
        this.setCustomerAddress(customerAddress);
        this.setCustomerContact(customerContact);
        this.setCustomerNIC(customerNIC);
        this.setCustomerLicenseNo(customerLicenseNo);
        this.setCustomerEmail(customerEmail);
        this.setCustomerNewPassword(customerNewPassword);
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerContact() {
        return customerContact;
    }

    public void setCustomerContact(String customerContact) {
        this.customerContact = customerContact;
    }

    public String getCustomerNIC() {
        return customerNIC;
    }

    public void setCustomerNIC(String customerNIC) {
        this.customerNIC = customerNIC;
    }

    public String getCustomerLicenseNo() {
        return customerLicenseNo;
    }

    public void setCustomerLicenseNo(String customerLicenseNo) {
        this.customerLicenseNo = customerLicenseNo;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerNewPassword() {
        return customerNewPassword;
    }

    public void setCustomerNewPassword(String customerNewPassword) {
        this.customerNewPassword = customerNewPassword;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerContact='" + customerContact + '\'' +
                ", customerNIC='" + customerNIC + '\'' +
                ", customerLicenseNo='" + customerLicenseNo + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", customerNewPassword='" + customerNewPassword + '\'' +
                '}';
    }
}
