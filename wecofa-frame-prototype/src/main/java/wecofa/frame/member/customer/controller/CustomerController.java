package wecofa.frame.member.customer.controller;


import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wecofa.frame.member.customer.entity.Customer;
import wecofa.frame.member.customer.service.CustomerService;
import wecofa.frame.web.Message;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(path = "/all" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Customer>> getCustomerList(){
        List<Customer> customerList = customerService.retrieveCustomerList();
        return new ResponseEntity<List<Customer>>(customerList, HttpStatus.OK);
    }

    @GetMapping(path = "/2/{cusId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> getCustomer(@PathVariable String cusId){
        Optional<Customer> o = customerService.retrieveCustomerByCusId(cusId);
        return new ResponseEntity<Customer>(o.orElse(new Customer()),HttpStatus.OK);
    }

    @GetMapping(path = "/3/{cusId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Message> getCustomerMessage(@PathVariable String cusId){
        Optional<Customer> o = customerService.retrieveCustomerByCusId(cusId);
        Message message = new Message(HttpStatus.OK,"SUCCESS",o.orElse(new Customer()));
        return new ResponseEntity<Message>(message,HttpStatus.OK);
    }


}
