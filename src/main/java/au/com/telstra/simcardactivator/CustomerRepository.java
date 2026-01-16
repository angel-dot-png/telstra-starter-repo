package au.com.telstra.simcardactivator;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

	Customer findBySimCardId(long simCardId);
}