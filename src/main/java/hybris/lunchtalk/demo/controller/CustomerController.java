package hybris.lunchtalk.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import hybris.lunchtalk.demo.model.PageModel;
import hybris.lunchtalk.demo.model.CustomerModel;
import hybris.lunchtalk.demo.dao.CustomerRepository;

@Controller
public class CustomerController {

	private static final int BUTTONS_TO_SHOW = 3;
	private static final int INITIAL_PAGE = 0;
	private static final int INITIAL_PAGE_SIZE = 5;
	private static final int[] PAGE_SIZES = { 5, 10 };
	
	@Autowired
	CustomerRepository customerRepository;

	@GetMapping("/")
	public ModelAndView homePage(@RequestParam("pageSize") Optional<Integer> pageSize,
			@RequestParam("page") Optional<Integer> page) {

		if (customerRepository.count() != 0) {
			;// pass
		} else {
			addToRepository();
		}

		ModelAndView modelAndView = new ModelAndView("index");
		//
		// Evaluate page size. If requested parameter is null, return initial
		// page size
		int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
		// Evaluate page. If requested parameter is null or less than 0 (to
		// prevent exception), return initial size. Otherwise, return value of
		// param. decreased by 1.
		int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;
		// print repo
		System.out.println("here is customer repo " + customerRepository.findAll());
		Page<CustomerModel> customerList = customerRepository.findAll(new PageRequest(evalPage, evalPageSize));
		System.out.println("customer list get total pages" + customerList.getTotalPages() + "customer list get number "
				+ customerList.getNumber());
		PageModel pager = new PageModel(customerList.getTotalPages(), customerList.getNumber(), BUTTONS_TO_SHOW);
		// add customermodel
		modelAndView.addObject("customerList", customerList);
		// evaluate page size
		modelAndView.addObject("selectedPageSize", evalPageSize);
		// add page sizes
		modelAndView.addObject("pageSizes", PAGE_SIZES);
		// add pager
		modelAndView.addObject("pager", pager);

		return modelAndView;
	}

	public void addToRepository() {

		// below we are adding customers to our repository for the sake of this example
		CustomerModel c1 = new CustomerModel();
		c1.setAddress("12345 Street");
		c1.setCurrentInvoice(10000);
		c1.setName("Customer 1");

		customerRepository.save(c1);

		// next customer
		CustomerModel c2 = new CustomerModel();
		c2.setAddress("12345 Street");
		c2.setCurrentInvoice(20000);
		c2.setName("Customer 2");

		customerRepository.save(c2);

		// next customer
		CustomerModel c3 = new CustomerModel();
		c3.setAddress("12345 Street");
		c3.setCurrentInvoice(30000);
		c3.setName("Customer 3");
		customerRepository.save(c3);

		// next customer
		CustomerModel c4 = new CustomerModel();
		c4.setAddress("12345 Street");
		c4.setCurrentInvoice(40000);
		c4.setName("Customer 4");
		customerRepository.save(c4);

		// next customer
		CustomerModel c5 = new CustomerModel();
		c5.setAddress("12345 Street");
		c5.setCurrentInvoice(50000);
		c5.setName("Customer 5");
		customerRepository.save(c5);

		// next customer
		CustomerModel c6 = new CustomerModel();
		c6.setAddress("12345 Street");
		c6.setCurrentInvoice(60000);
		c6.setName("Customer 6");
		customerRepository.save(c6);

		// next customer
		CustomerModel c7 = new CustomerModel();
		c7.setAddress("12345 Street");
		c7.setCurrentInvoice(60000);
		c7.setName("Customer 7");
		customerRepository.save(c7);

		// next customer
		CustomerModel c8 = new CustomerModel();
		c8.setAddress("12345 Street");
		c8.setCurrentInvoice(60000);
		c8.setName("Customer 8");
		customerRepository.save(c8);

		// next customer
		CustomerModel c9 = new CustomerModel();
		c9.setAddress("12345 Street");
		c9.setCurrentInvoice(60000);
		c9.setName("Customer 9");
		customerRepository.save(c9);

		// next customer
		CustomerModel c10 = new CustomerModel();
		c10.setAddress("12345 Street");
		c10.setCurrentInvoice(60000);
		c10.setName("Customer 10");
		customerRepository.save(c10);

		// next customer
		CustomerModel c11 = new CustomerModel();
		c11.setAddress("12345 Street");
		c11.setCurrentInvoice(60000);
		c11.setName("Customer 11");
		customerRepository.save(c11);
	}
}