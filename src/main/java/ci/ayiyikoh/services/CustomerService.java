package ci.ayiyikoh.services;

import ci.ayiyikoh.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    CustomerDto createCustomer(CustomerDto customerDto);
    CustomerDto getCustomerById(Long customerId);

    List<CustomerDto> getAllCustomers();

    CustomerDto updateCustomer(CustomerDto customerDto);

    void deleteCustomer(Long customerId);

}
