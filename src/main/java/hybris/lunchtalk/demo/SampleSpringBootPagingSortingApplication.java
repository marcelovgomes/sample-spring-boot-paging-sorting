package hybris.lunchtalk.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import hybris.lunchtalk.demo.dao.CustomerRepository;

@SpringBootApplication
public class SampleSpringBootPagingSortingApplication {

	@Autowired
	CustomerRepository clientrepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SampleSpringBootPagingSortingApplication.class, args);
	}
}
