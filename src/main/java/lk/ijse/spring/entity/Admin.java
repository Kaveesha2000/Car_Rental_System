package lk.ijse.spring.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin {

    @Id
    private String adminId;
    private String userName;
    private String adminPassword;

    public Admin() {
    }

    public Admin(String adminId, String userName, String adminPassword) {
        this.setAdminId(adminId);
        this.setUserName(userName);
        this.setAdminPassword(adminPassword);
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId='" + adminId + '\'' +
                ", userName='" + userName + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                '}';
    }
}
