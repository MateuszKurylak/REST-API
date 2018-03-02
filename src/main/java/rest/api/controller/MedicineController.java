package rest.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rest.api.medicines.Medicine;
import rest.api.service.MedicineService;


@RestController
public class MedicineController {
	
	@Autowired
	private MedicineService MedicineService;
	

	@RequestMapping("/medicines")
	public List<Medicine> getAllMedicines() {
		return MedicineService.getAllMedicines();
	}
	
	@RequestMapping("medicines/{id}")
	public Medicine getMedicine(@PathVariable String id) {
		return MedicineService.getMedicine(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/medicines")
	public void addMedicine(@RequestBody Medicine medicine) {
		MedicineService.addMedicine(medicine);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/medicines/{id}")
	public void updateMedicine(@RequestBody Medicine medicine, @PathVariable String id) {
		MedicineService.updateMedicine(id, medicine);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="medicines/{id}")
	public void deleteMedicine(@PathVariable String id) {
		MedicineService.deleteMedicine(id);
	}
}
