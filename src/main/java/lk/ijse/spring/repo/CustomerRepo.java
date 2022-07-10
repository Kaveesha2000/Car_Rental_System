package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Customer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer,String> {

    //query methods
    Customer findCustomerByCustomerName(String customerName);

    Customer findCustomerByCustomerAddress(String customerAddress);

    Customer findCustomerByCustomerNameAndCustomerAddress(String customerName, String customerAddress);

    Customer findByCustomerName(String customerName);

    Customer readByCustomerName(String customerName);

    Customer getByCustomerName(String customerName);

    Customer queryByCustomerName(String customerName);

    //Customer searchByName(String name);

    // If there is only one record you can set the return type as follow
    Customer streamByCustomerName(String customerName);

    //If the query has more than one result you have
    //to change the method return type to list
    List<Customer> searchByName(String customerName);


    //test countBy
    long countByCustomerName(String customerName);


    //test existBy
    boolean existsByCustomerNameAndCustomerAddress(String customerName, String customerAddress);


    //native sql
    @Query(value = "select * from Customer", nativeQuery = true)
    List<Customer> getAllCustomers();


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
    @Query(value = "select * from Customer where customerName=?1 and customerAddress=?2", nativeQuery = true)
    Customer searchCustomerFromName(String customerName, String customerAddress);

    /*//native sql with params
    //named params
    @Query(value = "select * from Customer where customerName=:name and customerAdderess=:address", nativeQuery = true)
    Customer searchCustomerFromNameWithNamedPara(@Param("name") String name, @Param("address") String address);


    //JPQL = Java Persistence Query Language
    @Query(value = "select c from Customer c where c.customerId=?1")
    Customer getAllCustomersWithJPQLWithParams(String id);
*/
}
