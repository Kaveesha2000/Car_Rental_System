package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DriverRepo extends JpaRepository<Driver,String> {
    Driver findDriverByDriverName(String customerName);

    Driver findDriverByDriverAddress(String customerAddress);

    Driver findCustomerByDriverNameAndDriverAddress(String customerName, String customerAddress);

    Driver findByDriverName(String customerName);

    Driver readByDriverName(String customerName);

    Driver getByDriverName(String customerName);

    Driver queryByDriverName(String customerName);

    //Customer searchByName(String name);

    // If there is only one record you can set the return type as follow
    Driver streamByDriverName(String customerName);

    //If the query has more than one result you have
    //to change the method return type to list
    List<Driver> searchByName(String customerName);


    //test countBy
    long countByDriverName(String customerName);


    //test existBy
    boolean existsByDriverNameAndDriverAddress(String customerName, String customerAddress);


    //native sql
    @Query(value = "select * from Driver", nativeQuery = true)
    List<Driver> getAllCustomers();


   /* //JPQL = Java Persistence Query Language
    @Query(value = "select c from Customer c")
    List<Customer> getAllCustomersWithJPQL();


    //HQL = Hibernate Query Language
    @Query(value = "from Customer c")
    List<Customer> getAllCustomersWithHQL(Pageable p);*/


    //Parameters
    //01 Positional Params =?1
    //02 Named Params =:name


    //native sql with params
    //positional params
    @Query(value = "select * from Driver where driverName=?1 and driverAddress=?2", nativeQuery = true)
    Driver searchDriverFromName(String driverName, String driverAddress);

    /*//native sql with params
    //named params
    @Query(value = "select * from Customer where customerName=:name and customerAdderess=:address", nativeQuery = true)
    Customer searchCustomerFromNameWithNamedPara(@Param("name") String name, @Param("address") String address);


    //JPQL = Java Persistence Query Language
    @Query(value = "select c from Customer c where c.customerId=?1")
    Customer getAllCustomersWithJPQLWithParams(String id);*/
}

