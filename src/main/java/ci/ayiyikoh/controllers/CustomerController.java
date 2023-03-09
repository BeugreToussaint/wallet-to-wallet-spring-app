package ci.ayiyikoh.controllers;

import ci.ayiyikoh.dto.CustomerDto;
import ci.ayiyikoh.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/customers")
public class CustomerController {
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto){
        CustomerDto customerDto1 = customerService.createCustomer(customerDto);
        return new ResponseEntity<>(customerDto1, HttpStatus.CREATED);
    }

    @GetMapping({"id"})
    public ResponseEntity<CustomerDto> getCustomerId(@PathVariable("id") Long customerId){
        CustomerDto customerDto = customerService.getCustomerById(customerId);
        return new ResponseEntity<>(customerDto, HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomers(){
        List<CustomerDto> customers = customerService.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @PutMapping({"id"})
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable("id") Long customerId , @RequestBody  CustomerDto customerDto){
        customerDto.setCustomerId(customerId);
        CustomerDto customerDto1 = customerService.updateCustomer(customerDto);
        return new ResponseEntity<>(customerDto1, HttpStatus.OK);
    }

    @DeleteMapping({"id"})
    public ResponseEntity<String> deleteCustomer(@PathVariable("") Long customerId){
        customerService.deleteCustomer(customerId);
        return new ResponseEntity<>("Customer successful deleted", HttpStatus.OK);
    }
}
