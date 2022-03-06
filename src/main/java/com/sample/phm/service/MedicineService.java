package com.sample.phm.service;

import com.sample.phm.entity.Medicine;
import com.sample.phm.entity.Stock;
import com.sample.phm.exception.BadMedicineCredentialException;
import com.sample.phm.exception.MedicineNotFoundException;
import com.sample.phm.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class MedicineService {

    @Autowired
    MedicineRepository medicineRepository;

    @Autowired
    StockService stockService;

    public ArrayList<Medicine> getAllMedicines() {
        return (ArrayList<Medicine>) medicineRepository.findAll();
    }

    @Transactional(rollbackOn = {BadMedicineCredentialException.class})
    public boolean addMedicine(Medicine medicine) throws BadMedicineCredentialException {
        try{
            medicineRepository.save(medicine);
            Stock stock = new Stock(medicine.getId(), medicine.getCompany_id(), 0);

            stockService.addStock(stock);
            return true;
        } catch (Exception e) {
            throw new BadMedicineCredentialException("medicine credentials are not complete");
        }
    }

    public boolean update(Integer id, Medicine medicine) {

        Medicine medicine1 = medicineRepository.getById(id);

        if(medicine1 != null) {
            Medicine medicine2 = new Medicine(id,
                    medicine.getName(),
                    medicine.getCompany_id(),
                    medicine.getCost(),
                    medicine.getVolume());

            medicineRepository.save(medicine2);
            return true;
        } else
            return false;
    }

    public boolean deleteMedicine(Integer id) throws MedicineNotFoundException {
        Optional<Medicine> medicine = medicineRepository.findById(id);
        if(medicine.isPresent()) {
            medicineRepository.delete(medicine.get());
            return true;
        } else {
            throw new MedicineNotFoundException("medicine is not in database");
        }
    }
}
