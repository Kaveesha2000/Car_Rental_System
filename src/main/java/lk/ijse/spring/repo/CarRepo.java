package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepo extends JpaRepository<Car,String> {
//    Car findCarByBrand(String brand);
//
//    Car findCarByDriverAddress(String customerAddress);
//
//    Car findCustomerByDriverNameAndDriverAddress(String customerName, String customerAddress);
//
//    Car findByDriverName(String customerName);
//
//    Car readByDriverName(String customerName);
//
//    Car getByDriverName(String customerName);
//
//    Car queryByDriverName(String customerName);
//
//    Car streamByDriverName(String customerName);
//
//    List<Car> searchByName(String customerName);
//
//
//    //test countBy
//    long countByDriverName(String customerName);
//
//
//    //test existBy
//    boolean existsByDriverNameAndDriverAddress(String customerName, String customerAddress);
//
//
//    //native sql
//    @Query(value = "select * from Car", nativeQuery = true)
//    List<Car> getAllDriver();
//
//    /*@Query(value = "select * from Car where carBrand=?1 and driverAddress=?2", nativeQuery = true)
//    Car searchDriverFromName(String driverName, String driverAddress);*/
}
