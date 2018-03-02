package rest.api.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import rest.api.medicines.Medicine;

@Repository
public interface MedicineRepository extends CrudRepository<Medicine, String>{

	
	
}
