package me.study.demomongo.example.customer;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Customer {

    @Id
    public String id;

    public String firstName;
    public String lastName;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    static public Customer createCustomer(CustomerSaveRequest customerSaveRequest) {
        return new Customer(
                customerSaveRequest.firstName,
                customerSaveRequest.lastName
        );
    }
}