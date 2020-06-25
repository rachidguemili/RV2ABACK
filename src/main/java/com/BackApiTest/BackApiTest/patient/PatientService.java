package com.BackApiTest.BackApiTest.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

	@Autowired
	PatientRepository patientRepository;

	public List<Patient> getAll() {
		return  patientRepository.findAll();
	}


	public Patient getById(Long id) {
		return patientRepository.findById(id).get();
	}
}