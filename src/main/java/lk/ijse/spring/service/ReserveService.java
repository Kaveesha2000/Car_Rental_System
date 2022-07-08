package lk.ijse.spring.service;

import lk.ijse.spring.dto.ReserveDTO;

import java.util.List;

public interface ReserveService {
    void saveReserve(ReserveDTO dto);
    void updateReserve(ReserveDTO dto);
    ReserveDTO searchReserve(String id);
    List<ReserveDTO> getAllReserve();
}
