package me.study.demomongo.example.customer;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CustomerController {
    private final CustomerRepository customerRepository;

    @PostMapping("/customer")
    public ResponseEntity<Void> saveCustomer(
            @RequestBody CustomerSaveRequest customerSaveRequest
    ) {
        customerRepository.save(Customer.createCustomer(customerSaveRequest));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
