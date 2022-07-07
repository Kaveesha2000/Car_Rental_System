package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class ReserveDTO {
    private String reserveId;
    private String pickedDate;
    private String pickedTime;
    private String returnDate;
    private String returnTime;
    private String destination;
    private boolean driverWantOrNot;
    private String acceptOrDeny;
}
