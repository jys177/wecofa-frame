package wecofa.frame.member.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wecofa.frame.member.customer.entity.Customer;
import wecofa.frame.member.customer.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void createMember(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void updateMember(Customer customer) {
        Long cusNo = customer.getCusNo();
        Optional<Customer> e = customerRepository.findById(cusNo);
        if(e.isPresent()){
            customerRepository.save(customer);
        }
    }

    @Override
    public void updateMemberByCusNo(Long cusNo,Customer customer) {
        Optional<Customer> e = customerRepository.findById(cusNo);
        if(e.isPresent()){
            Customer updateCustomer=e.get();
            updateCustomer.setCusId(customer.getCusId());
            updateCustomer.setCusBalance(customer.getCusBalance());
            updateCustomer.setCusBirthday(customer.getCusBirthday());
            updateCustomer.setCusName(customer.getCusName());
            customerRepository.save(updateCustomer);
        }
    }

    @Override
    public List<Customer> retrieveCustomerList() {
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach(c -> customers.add(c));
        return customers;
    }

    @Override
    public Optional<Customer> retrieveCustomer(Long cusNo) {
        Optional<Customer> customer=customerRepository.findById(cusNo);
        return customer;
    }

    @Override
    public Optional<Customer> retrieveCustomerByCusId(String cusId){
        Optional<Customer> customer = customerRepository.findCustomerByCusId(cusId);
        return customer;
    }

    @Override
    public void deleteMember(Long cusNo) {
        customerRepository.deleteById(cusNo);
    }
}
