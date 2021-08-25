package wecofa.frame.member.customer.service;

import wecofa.frame.member.customer.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    public void createMember(Customer customer);

    public void updateMember(Customer customer);

    public void updateMemberByCusNo(Long cusNo, Customer customer);

    public List<Customer> retrieveCustomerList();

    public Optional<Customer> retrieveCustomer(Long cusNo);

    public Optional<Customer> retrieveCustomerByCusId(String cusId);

    public void deleteMember(Long cusNo);
}
