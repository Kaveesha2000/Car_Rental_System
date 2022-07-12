package lk.ijse.spring.service;

import lk.ijse.spring.dto.ScheduleDTO;

import java.util.List;

public interface ScheduleService {
    void saveSchedule(ScheduleDTO dto);
    void updateSchedule(ScheduleDTO dto);
    ScheduleDTO searchSchedule(String id);
    List<ScheduleDTO> getAllSchedule();
    String generateScheduleIds();
}
