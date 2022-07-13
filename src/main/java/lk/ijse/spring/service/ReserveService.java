package lk.ijse.spring.service;

import lk.ijse.spring.dto.ReserveDTO;

import java.util.List;

public interface ReserveService {
    void reserve(ReserveDTO dto);
    void updateReserve(ReserveDTO dto);
    ReserveDTO searchReserve(String id);
    List<ReserveDTO> getAllReserve();
    String generateReserveId();
    int countDailyReservation(String bookingDate);
    int activeReservationsPerDay(String acceptedRequests);
}
