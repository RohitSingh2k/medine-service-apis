package com.sample.phm.controller;

import com.sample.phm.entity.Medicine;
import com.sample.phm.entity.MedicineResponse;
import com.sample.phm.exception.BadMedicineCredentialException;
import com.sample.phm.exception.MedicineNotFoundException;
import com.sample.phm.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    /**
     * Get all medicine list
     * @return List<Medicine>
     */
    @GetMapping("/medicine")
    public List<Medicine> fetchAllMedicine() {
        return medicineService.getAllMedicines();
    }

    /**
     * Add a medicine into database
     * @param medicine
     * @return MedicineResponse
     * @throws BadMedicineCredentialException
     */
    @PostMapping("/medicine")
    public MedicineResponse addMedicine(@RequestBody Medicine medicine) throws BadMedicineCredentialException {
        if(medicineService.addMedicine(medicine)) {
            return new MedicineResponse(HttpStatus.ACCEPTED , true,"Medicine added successfully!");
        } else{
            throw new BadMedicineCredentialException("Medicine details are not sufficient");
        }
    }

    /**
     * Update details of a medicine
     * @param medicine
     * @param id
     * @return MedicineResponse
     * @throws MedicineNotFoundException
     */
    @PutMapping("/medicine/{id}")
    public MedicineResponse updateMedicine(@RequestBody Medicine medicine, @PathVariable("id") Integer id) throws MedicineNotFoundException {
        if(medicineService.update(id,medicine)) {
            return new MedicineResponse(HttpStatus.ACCEPTED , true, "Medicine updated successfully");
        } else {
            throw new MedicineNotFoundException("Medicine with this id does not Exists!");
        }
    }

    /**
     * Delete medicine from database
     * @param id
     * @return MedicineResponse
     * @throws MedicineNotFoundException
     */
    @DeleteMapping("/medicine/{id}")
    public MedicineResponse deleteMedicine(@PathVariable Integer id) throws MedicineNotFoundException {
        if(medicineService.deleteMedicine(id)) {
            return new MedicineResponse(HttpStatus.FOUND,true,"Medicine deleted successfully!");
        } else {
            throw new MedicineNotFoundException("Medicine with this id not exists in database");
        }
    }


}
