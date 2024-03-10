package com.doctorapp.client;

import com.doctorapp.model.Doctor;
import com.doctorapp.model.Specialization;
import com.doctorapp.service.DoctorServiceImpl;
import com.doctorapp.service.IDoctorService;

public class User {
    public User() {
    }

    public static void main(String[] args) {
        IDoctorService doctorService = new DoctorServiceImpl();
        Specialization specialization = Specialization.DERMA;


        String speciality = specialization.getSpeciality();

        String special = Specialization.DERMA.getSpeciality();


        Doctor doctor = new Doctor("Pooja", speciality, 5000, 9, 15);
        doctorService.addDoctor(doctor);
    }
}
