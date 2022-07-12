package lk.ijse.spring.service.impl;

import lk.ijse.spring.config.WebAppConfig;
import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@WebAppConfiguration
@ContextConfiguration(classes = {WebAppConfig.class})
@ExtendWith(SpringExtension.class)
@Transactional
public class CustomerServiceImplTest {
    @Autowired
    CustomerService customerService;

    @Test
    //add One Customer for testing
    public CustomerDTO addOneCustomer() {
        //If it is a new Customer It should added to the database
        //return new CustomerDTO("C001","Dasun","Galle","0775263246","552224111210","CD5241","hjajsh@gmail.com","Dasu344444");
        return null;
    }

    @Test
    //Add multiple customers for testing
    public void addCustomers(){
       /* CustomerDTO c1 = new CustomerDTO("C001","Dasun","Galle","0775263246","552224111210","CD5241","hjajsh@gmail.com","Dasu344444");
        CustomerDTO c2 = new CustomerDTO("C002","Kasun","Panadura","0775263246","552224111210","CD5241","hjajsh@gmail.com","Dasu344444");
        CustomerDTO c3 = new CustomerDTO("C003","Ramal","Galle","0775263246","552224111210","CD5241","hjajsh@gmail.com","Dasu344444");*/
        //CustomerDTO c4 = new CustomerDTO("C004","Supun","Galle","0775263246","552224111210","CD5241","hjajsh@gmail.com","Dasu344444");

        /*customerService.saveCustomer(c1);
        customerService.saveCustomer(c2);
        customerService.saveCustomer(c3);*/
        //customerService.saveCustomer(c4);

    }


    @Test
    void saveCustomer() {

        CustomerDTO customerDTO = addOneCustomer();
        //Check there is no errors
        //If there are no errors test ok
        //If there are errors test is false
        assertDoesNotThrow(() -> {
            customerService.saveCustomer(customerDTO);
        });

        // If the customer already exist. check if it is throwing the error
        CustomerDTO customerDTO2 =addOneCustomer();

        //Check if there is a error. If there is a error test is ok
        //If there is no error test case false
        assertThrows(RuntimeException.class, () -> {
            customerService.saveCustomer(customerDTO2);
        });

    }

    @Test
    void deleteCustomer() {
        //Add multiple customers
        addCustomers();

        // delete existing customer
        assertDoesNotThrow(()->{
            customerService.deleteCustomer("C001");
        });

        //delete an non existing customer
        assertThrows(RuntimeException.class,()->{
            customerService.deleteCustomer("C016");
        });

    }

    /*@Test
    void updateCustomer() {
        //Add multiple customers
        addCustomers();

        //update an existing customer
        assertDoesNotThrow(()->{
            customerService.updateCustomer(new CustomerDTO("C001","Dasun","Galle","0775263246","552224111210","CD5241","hjajsh@gmail.com","Dasu344444"));
        });

        //update an non existing customer
        //should throw an exception
        assertThrows(RuntimeException.class,()->{
            customerService.updateCustomer(new CustomerDTO("C004","Nimal","Galle","0775263246","552224111210","CD5241","hjajsh@gmail.com","Dasu344444"));
        });



    }*/

    @Test
    void searchCustomer() {
        CustomerDTO customer = addOneCustomer();
        customerService.saveCustomer(customer);

        //search an available customer
        CustomerDTO c001 = customerService.searchCustomer("C001");
        assertNotNull(c001); // check customer is null or not

        /*
        check non existing customer
        should throw error
        */
        assertThrows(RuntimeException.class, () -> {
            CustomerDTO c002 = customerService.searchCustomer("C002");
        });
    }

    @Test
    void getAllCustomers() {
        //add multiple customers
        addCustomers();

        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
        for (CustomerDTO allCustomer : allCustomers) {
            System.out.println(allCustomer.toString());
        }

        //Test customer availability
        assertNotNull(allCustomers);

    }
}
