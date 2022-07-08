package lk.ijse.spring.service;

import lk.ijse.spring.dto.RentDTO;

import java.util.List;

public interface RentService {
    void saveRent(RentDTO dto);
    void updateRent(RentDTO dto);
    RentDTO searchRent(String id);
    List<RentDTO> getAllRent();
}
