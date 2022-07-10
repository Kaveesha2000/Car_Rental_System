package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DriverRepo extends JpaRepository<Driver,String> {
    Driver findDriverByDriverName(String driverName);

    Driver findDriverByDriverAddress(String driverAddress);

    Driver findCustomerByDriverNameAndDriverAddress(String driverName, String driverAddress);

    Driver findByDriverName(String driverName);

    Driver readByDriverName(String driverName);

    Driver getByDriverName(String driverName);

    Driver queryByDriverName(String driverName);

    Driver streamByDriverName(String driverName);

    List<Driver> searchByName(String driverName);


    //test countBy
    long countByDriverName(String driverName);


    //test existBy
    boolean existsByDriverNameAndDriverAddress(String driverName, String driverAddress);


    //native sql
    @Query(value = "select * from Driver", nativeQuery = true)
    List<Driver> getAllDriver();

    @Query(value = "select * from Driver where driverName=?1 and driverAddress=?2", nativeQuery = true)
    Driver searchDriverFromName(String driverName, String driverAddress);

}

