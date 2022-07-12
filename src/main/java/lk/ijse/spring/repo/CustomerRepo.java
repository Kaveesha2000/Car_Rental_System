package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer,String> {

    //native sql
    /*@Query(value = "select * from Customer", nativeQuery = true)
    List<Customer> getAllCustomers();*/

    @Query(value = "SELECT customerId FROM Customer ORDER BY customerId DESC LIMIT 1", nativeQuery = true)
    String generateCustomerId();

    @Query(value = "SELECT COUNT(*) FROM Customer", nativeQuery = true)
    int registeredCustomerCount();

    @Query(value = "SELECT COUNT(*) FROM Customer WHERE customerRegisteredDate=:customerRegisteredDate;", nativeQuery = true)
    int dailyRegisteredCustomerCount(@Param("customerRegisteredDate") String customerRegisteredDate);
}
