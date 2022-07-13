package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.ReserveDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.entity.Reserve;
import lk.ijse.spring.repo.ReserveRepo;
import lk.ijse.spring.service.ReserveService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ReserveServiceImpl implements ReserveService {

    @Autowired
    private ReserveRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void reserve(ReserveDTO dto) {
        if (!repo.existsById(dto.getReserveId())) {
            repo.save(mapper.map(dto, Reserve.class));
        }else {
            throw new RuntimeException("Reserve Already Exist...!");
        }
    }

    @Override
    public void updateReserve(ReserveDTO dto) {
        if (repo.existsById(dto.getReserveId())){
            repo.save(mapper.map(dto,Reserve.class));
        }else {
            throw new RuntimeException("No such reserve. Try again...!");
        }
    }

    @Override
    public ReserveDTO searchReserve(String id) {
        if (repo.existsById(id)){
            return mapper.map(repo.findById(id).get(), ReserveDTO.class);
        }else {
            throw new RuntimeException("No reserve for the id "+id+". Try again...!");
        }
    }

    @Override
    public List<ReserveDTO> getAllReserve() {
        return mapper.map(repo.findAll(), new TypeToken<List<ReserveDTO>>() {
        }.getType());
    }

    @Override
    public String generateReserveId() {
        return repo.generateReserveId();
    }

    @Override
    public int countDailyReservation(String bookingDate) {
        return repo.countDailyReservations(bookingDate);
    }

    @Override
    public int activeReservationsPerDay(String acceptedRequests) {
        return repo.activeReservationPerDay(acceptedRequests);
    }
}
