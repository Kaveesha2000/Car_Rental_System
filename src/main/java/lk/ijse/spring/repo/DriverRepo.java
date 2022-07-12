package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DriverRepo extends JpaRepository<Driver,String> {

    //native sql
    @Query(value = "select * from Driver", nativeQuery = true)
    List<Driver> getAllDriver();

    @Query(value = "select COUNT(*) from Driver where driverReleaseOrNot=:driverReleaseOrNot",nativeQuery = true)
    int releaseOrNotCount(@Param("driverReleaseOrNot") boolean driverReleaseOrNot);

}

