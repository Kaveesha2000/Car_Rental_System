package lk.ijse.spring.repo;

import lk.ijse.spring.config.JPAConfig;
import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@WebAppConfiguration
@ContextConfiguration(classes = {JPAConfig.class})
@ExtendWith(SpringExtension.class)
@Transactional
public class CustomerRepoTest {

    @Autowired
    CustomerRepo customerRepo;

    public void addCustomers(){
        Customer customer1 = new Customer("C001","Dasun","Galle","0775263246","552224111210","CD5241","hjajsh@gmail.com","Dasu344444");
        Customer customer2 = new Customer("C002","Kasun","Panadura","0775263246","552224111210","CD5241","hjajsh@gmail.com","Dasu344444");
        Customer customer3 = new Customer("C003","Ramal","Galle","0775263246","552224111210","CD5241","hjajsh@gmail.com","Dasu344444");
        customerRepo.save(customer1);
        customerRepo.save(customer2);
        customerRepo.save(customer3);
    }
    @Test
    public void saveCustomer() {
      addCustomers();
    }

    @Test
    public void getAllCustomers() {
        addCustomers();
        List<Customer> all = customerRepo.findAll();
        for (Customer customer : all) {
            System.out.println(customer.toString());
        }
    }

    @Test
    public void searchCustomer() {
        addCustomers();
        Optional<Customer> optional = customerRepo.findById("C001");
        boolean present = optional.isPresent();
        System.out.println(present);

        Customer customer = optional.get();
        System.out.println(customer);

    }

    @Test
    public void deleteCustomer() {
        customerRepo.deleteById("C001");
    }

    @Test
    public void updateCustomer(){
        if (customerRepo.existsById("C009")) {
            Customer customer1 = new Customer("C001","Dasun","Galle","0775263246","552224111210","CD5241","hjajsh@gmail.com","Dasu344444");
            customerRepo.save(customer1);
        }else{
            throw new RuntimeException("No Such Customer To Update");
        }

    }

    @Test
    public void testDTO(){
        CustomerDTO customerDTO = new CustomerDTO("","","","04152663301","","","","");
        System.out.println(customerDTO);
    }

    @Test
    public void searchCustomerByName(){
        Customer c1 = customerRepo.findByCustomerName("Kasun");
        Customer c2 = customerRepo.findByCustomerName("Kasun");
        System.out.println(c1.toString());
        System.out.println(c2.toString());
    }

    @Test
    public void searchCustomerByAddress(){
        Customer c1 = customerRepo.findCustomerByCustomerAddress("Galle");
        System.out.println(c1.toString());
    }

    @Test
    public void searchCustomerByNameAndAddress(){
        Customer c1 = customerRepo.findCustomerByCustomerNameAndCustomerAddress("Kasun","Galle");
        System.out.println(c1.toString());
    }

    @Test
    public void searchByName(){
        List<Customer> customers = customerRepo.searchByCustomerName("Dasun");
        for (Customer customer : customers) {
            System.out.println(customer.toString());
        }
    }


    @Test
    public void t1(){
        Customer c1 = customerRepo.findCustomerByCustomerName("Dasun");
        System.out.println(c1.toString());

        Customer c2 = customerRepo.readByCustomerName("Dasun");
        System.out.println(c2.toString());

        Customer c3 = customerRepo.readByCustomerName("Dasun");
        System.out.println(c3.toString());

        Customer c4 = customerRepo.queryByCustomerName("Dasun");
        System.out.println(c4.toString());

        Customer c6 = customerRepo.streamByCustomerName("Kasun");
        System.out.println(c6.toString());
    }



    @Test
    public void testCountBy(){
        long ramal = customerRepo.countByCustomerName("Ramal");
        System.out.println(ramal);
    }

    @Test
    public void testExistBy(){
        boolean b = customerRepo.existsByCustomerNameAndCustomerAddress("Kamal", "Galle");
        System.out.println(b);
    }

    @Test
    public void textQueryOne(){
        List<Customer> allCustomers = customerRepo.getAllCustomers();
        allCustomers.forEach(v->{
            System.out.println(v.toString());
        });
    }

   /* @Test
    public void textQueryTwo(){
        List<Customer> allCustomers = customerRepo.getAllCustomersWithJPQL();
        allCustomers.forEach(v->{
            System.out.println(v.toString());
        });
    }

    @Test
    public void textQueryThree(){
        PageRequest pr = PageRequest.of(1, 3,Sort.by("id").descending());
        List<Customer> allCustomers = customerRepo.getAllCustomersWithHQL(pr);

        allCustomers.forEach(v->{
            System.out.println(v.toString());
        });
    }*/

    @Test
    public void textQueryFour(){
        Customer customer = customerRepo.searchCustomerFromName("Ramal","Galle");
        System.out.println(customer.toString());
    }

    @Test
    public void textQueryFive(){
        Customer customer = customerRepo.searchCustomerFromName("Kamal","Galle");
        System.out.println(customer.toString());
    }

    @Test
    public void textQuerySix(){
        Customer customer = customerRepo.getByCustomerId("C001");
        System.out.println(customer.toString());
    }


    /*@Test
    public void checkPageableFeatures(){
        //page - page number, starts with 0
        //size - count of records for a page

        PageRequest pr = PageRequest.of(0, 4, Sort.by("id").descending());

        Page<Customer> all = customerRepo.findAll(pr);
        all.forEach(v->{
            System.out.println(v.toString());
        });

    }*/
}
