package ci.ayiyikoh.mapper;

import ci.ayiyikoh.dto.CustomerDto;
import ci.ayiyikoh.models.Customer;

public class CustomerMapper {
    public static CustomerDto mapToCustomerDto(Customer customer){
        CustomerDto customerDto = new CustomerDto(
                customer.getCustomerId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getPhoneNumber(),
                customer.getEmailAdreesse(),
                customer.getStreet(),
                customer.getCountry(),
                customer.getCity());

        return customerDto;
    }

    public static Customer mapToCustomer(CustomerDto customerDto){
        Customer customer = new Customer(
                customerDto.getFirstName(),
                customerDto.getLastName(),
                customerDto.getPhoneNumber(),
                customerDto.getEmailAdreesse(),
                customerDto.getStreet(),
                customerDto.getCountry(),
                customerDto.getCity()
                );
        return customer;
    }
}
