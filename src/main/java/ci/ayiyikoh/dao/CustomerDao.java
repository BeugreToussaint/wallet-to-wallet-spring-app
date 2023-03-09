package ci.ayiyikoh.dao;

import ci.ayiyikoh.dto.CustomerDto;
import ci.ayiyikoh.mapper.CustomerMapper;
import ci.ayiyikoh.models.Customer;
import ci.ayiyikoh.repository.CustomerRepository;
import ci.ayiyikoh.services.CustomerService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CustomerDao implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerDao(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer customer = CustomerMapper.mapToCustomer(customerDto);
        Customer customerSaved = customerRepository.save(customer);
        CustomerDto customerSavedDto = CustomerMapper.mapToCustomerDto(customerSaved);
        return customerSavedDto;
    }

    @Override
    public CustomerDto getCustomerById(Long customerId) {
        Optional<Customer> customerSaved = customerRepository.findById(customerId);
        CustomerDto customerSavedDto = CustomerMapper.mapToCustomerDto(customerSaved.get());
        return customerSavedDto;
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().map(CustomerMapper::mapToCustomerDto).collect(Collectors.toList());
    }

    @Override
    public CustomerDto updateCustomer(CustomerDto customerDto) {
        Customer existingCustomer = customerRepository.findById(customerDto.getCustomerId()).get();
        existingCustomer.setFirstName(customerDto.getFirstName());
        existingCustomer.setLastName(customerDto.getLastName());
        existingCustomer.setEmailAdreesse(customerDto.getEmailAdreesse());
        existingCustomer.setCountry(customerDto.getCountry());
        existingCustomer.setStreet(customerDto.getStreet());
        existingCustomer.setCity(customerDto.getCity());
        return CustomerMapper.mapToCustomerDto(existingCustomer);
    }

    @Override
    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }
}
