package wecofa.frame.member.customer.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import wecofa.frame.member.customer.entity.Customer;

import java.util.List;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/context-main.xml"})
public class CustomerServiceTest {

    private final static Logger logger = LoggerFactory.getLogger(CustomerServiceTest.class);

    @Autowired
    private CustomerService customerService;

   /* @Test
    public void createTest(){
        Customer customer = new Customer();
        customer.setCusId("CUS-00002");
        customer.setCusName("CUS-NAME-001");
        customer.setCusBalance(100000);
        customer.setCusBirthday(java.sql.Date.valueOf("2004-06-22"));

        customerService.createMember(customer);
    }*/
    @Test
    public void deleteTest(){
        //customerService.deleteMember(Long.valueOf(2));
    }

   /* @Test
    public void updateTest(){
        Customer customer = new Customer();
        customer.setCusNo(Long.valueOf(11));
        customer.setCusId("CUS-00002");
        customer.setCusName("CUS-NAME-002");
        customer.setCusBalance(200000);
        customer.setCusBirthday(java.sql.Date.valueOf("2004-06-23"));
        customerService.updateMember(customer);
    }*/

    /*@Test
    public void retrieveTest(){
        Optional<Customer> customer = customerService.retrieveCustomer(Long.valueOf(11));
        logger.debug("output : {}",customer);
        customer=customerService.retrieveCustomerByCusId("CUS-00002");
        logger.debug("output : {}",customer);

    }*/
    @Test
    public void retrieveTestList(){
        List<Customer> customers = customerService.retrieveCustomerList();
        logger.debug("output : {}",customers);
    }

}
