package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.entity.Car;
import lk.ijse.spring.repo.CarRepo;
import lk.ijse.spring.service.CarService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CarServiceImpl implements CarService{

    @Autowired
    private CarRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveCar(CarDTO dto) {
        if (!repo.existsById(dto.getCarId())) {
            repo.save(mapper.map(dto, Car.class));
        }else {
            throw new RuntimeException("Car Already Exist...!");
        }
    }

    @Override
    public void deleteCar(String id) {
        if (repo.existsById(id)){
            repo.deleteById(id);
        }else {
            throw new RuntimeException("There is no such car. Try again...!");
        }
    }

    @Override
    public void updateCar(CarDTO dto) {
        if (repo.existsById(dto.getCarId())){
            repo.save(mapper.map(dto,Car.class));
        }else {
            throw new RuntimeException("No such car. Try again...!");
        }
    }

    @Override
    public CarDTO searchCar(String id) {
        if (repo.existsById(id)){
            return mapper.map(repo.findById(id).get(), CarDTO.class);
        }else {
            throw new RuntimeException("No car for the id "+id+". Try again...!");
        }
    }

    @Override
    public List<CarDTO> getAllCar() {
        return mapper.map(repo.findAll(), new TypeToken<List<CarDTO>>() {
        }.getType());
    }
}
