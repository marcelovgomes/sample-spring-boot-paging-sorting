package hybris.lunchtalk.demo.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import hybris.lunchtalk.demo.model.CustomerModel;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<CustomerModel,Long> {

}
