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
public class Reserve {

    @Id
    private String reserveId;
    private String pickedDate;
    private String pickedTime;
    private String returnDate;
    private String returnTime;
    private String destination;
    private boolean driverWantOrNot;
    private String acceptOrDeny;

}
