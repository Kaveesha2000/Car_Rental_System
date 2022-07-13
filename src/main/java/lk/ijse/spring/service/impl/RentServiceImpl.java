package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.RentDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.entity.Rent;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.repo.RentRepo;
import lk.ijse.spring.service.RentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RentServiceImpl implements RentService{

    @Autowired
    private RentRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveRent(RentDTO dto) {
        if (!repo.existsById(dto.getPaymentId())) {
            repo.save(mapper.map(dto, Rent.class));
        }else {
            throw new RuntimeException("Rent Already Exist...!");
        }
    }

    @Override
    public void updateRent(RentDTO dto) {
        if (repo.existsById(dto.getPaymentId())){
            repo.save(mapper.map(dto,Rent.class));
        }else {
            throw new RuntimeException("No such rent. Try again...!");
        }
    }

    @Override
    public RentDTO searchRent(String id) {
        if (repo.existsById(id)){
            return mapper.map(repo.findById(id).get(), RentDTO.class);
        }else {
            throw new RuntimeException("No customer for the id "+id+". Try again...!");
        }
    }

    @Override
    public List<RentDTO> getAllRent() {
        return mapper.map(repo.findAll(), new TypeToken<List<RentDTO>>() {
        }.getType());
    }

    @Override
    public double dailyIncome(String rentDate) {
        return repo.dailyIncome(rentDate);
    }

    @Override
    public double income(String firstRentDate, String lastRentDate) {
        return repo.income(firstRentDate,lastRentDate);
    }
}
