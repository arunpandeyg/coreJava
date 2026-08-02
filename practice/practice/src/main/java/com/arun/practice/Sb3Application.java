package com.arun.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.Callable;


@SpringBootApplication
@RestController
@RequestMapping("/api/v1/customers")
public class Sb3Application {

	private final CustomerRepository customerRepository;

	public Sb3Application(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(Sb3Application.class, args);
	}
	@GetMapping
	public List<Customer> getCustomer(){
		return customerRepository.findAll();
	}
	record NewCustomerRequest(
			String name,
			String email,
			Integer age
	){

	}

	@PostMapping
	public void addCustomer(@RequestBody NewCustomerRequest request){
		Customer customer = new Customer();
		customer.setName(request.name());
		customer.setEmail(request.email());
		customer.setAge(request.age());
		customerRepository.save(customer);
	}

	@DeleteMapping("{customerId}")
	public void deleteCustomer(@PathVariable("customerId") Integer id){
		customerRepository.deleteById(id);
	}

	@PutMapping("{customerId}")
	public Customer updateCustomer(@RequestBody Customer customer, @PathVariable("customerId") Integer id){
		Customer updateCustomer = customerRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Employee not exist with id: " + id));

		updateCustomer.setName(customer.getName());
		updateCustomer.setEmail(customer.getEmail());
		updateCustomer.setAge(customer.getAge());
		customerRepository.save(updateCustomer);
		return updateCustomer;
	}

	/*@GetMapping("/greet")
	public GreetResponse greet(){

		GreetResponse response = new GreetResponse(
				"jai jai shri Ram !!",
		        List.of("Java", "Js", "python"),
				new Person("Raj", 12, 25000));
		return response;
	}
	record Person(String name, int age, double savings){

	}
	record GreetResponse(
			String greet,
	        List<String>favProgrammingLanguages, Person person){

	}*/

	/*class GreetResponse{
		private final String greet;


		GreetResponse(String greet) {
			this.greet = greet;
		}
		public  String getGreet(){
			return greet;
		}

		@Override
		public String toString() {
			return "GreetResponse{" +
					"greet='" + greet + '\'' +
					'}';
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			GreetResponse that = (GreetResponse) o;
			return Objects.equals(greet, that.greet);
		}

		@Override
		public int hashCode() {
			return Objects.hash(greet);
		}
	}*/

}
