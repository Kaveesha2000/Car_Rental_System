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
public class Schedule {

    @Id
    private String scheduleId;
    private String driverId;
    private String carId;
    private String pickedDate;
    private String pickedTime;
    private String returnDate;
    private String releasedOrNot;

}
