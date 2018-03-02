package rest.api.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rest.api.medicines.Medicine;


@Service
public class MedicineService {

	@Autowired
	private MedicineRepository MedicineRepository;
	
	private List<Medicine> medicines = new ArrayList<>(Arrays.asList(
			new Medicine("spring", "SpringFramework", "Framework Description"),
			new Medicine("java", "Core Java", "Core Java Description"),
			new Medicine("javascript", "JavaScript", "JavaScript Description")));

	public List<Medicine> getAllMedicines() {
		List<Medicine> medicines = new ArrayList<>();
		MedicineRepository.findAll()
		.forEach(medicines :: add);
		return medicines;
	}
	
	public Medicine getMedicine(String id) {
		return medicines.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addMedicine(Medicine medicine) {
		MedicineRepository.save(medicine);
	}

	public void updateMedicine(String id, Medicine medicine) {
		for(int i = 0; i < medicines.size(); i++) {
			Medicine t = medicines.get(i);
			if(t.getId().equals(id)) {
				medicines.set(i, medicine);
				return;
			}
		}
		
	}

	public void deleteMedicine(String id) {
		medicines.removeIf(t -> t.getId().equals(id));
	}
}
