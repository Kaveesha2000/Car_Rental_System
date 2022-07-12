package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.ScheduleDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.entity.Schedule;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.repo.ScheduleRepo;
import lk.ijse.spring.service.ScheduleService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveSchedule(ScheduleDTO dto) {
        if (!repo.existsById(dto.getScheduleId())) {
            repo.save(mapper.map(dto, Schedule.class));
        }else {
            throw new RuntimeException("Schedule Already Exist...!");
        }
    }

    @Override
    public void updateSchedule(ScheduleDTO dto) {
        if (repo.existsById(dto.getScheduleId())){
            repo.save(mapper.map(dto,Schedule.class));
        }else {
            throw new RuntimeException("No such schedule. Try again...!");
        }
    }

    @Override
    public ScheduleDTO searchSchedule(String id) {
        if (repo.existsById(id)){
            return mapper.map(repo.findById(id).get(), ScheduleDTO.class);
        }else {
            throw new RuntimeException("No customer for the id "+id+". Try again...!");
        }
    }

    @Override
    public List<ScheduleDTO> getAllSchedule() {
        return mapper.map(repo.findAll(), new TypeToken<List<ScheduleDTO>>() {
        }.getType());
    }

    @Override
    public String generateScheduleIds() {
        return repo.generateScheduleId();
    }
}
