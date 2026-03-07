package com.example.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankCOntroller {

	@PostMapping("bank/openAccount")
	String openAccount(@RequestBody Customer c) {
		CustomerService cs = new CustomerService();
		String msg = cs.saveCustomerInDb(c);

		return msg;
	}
}

class CustomerService {
	String saveCustomerInDb(Customer c) {

		if (c.getAge() < 18) {
			return "age should be greter than 18";
		}

		return "account is opened";

	}

}
