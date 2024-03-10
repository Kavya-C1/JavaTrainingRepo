package com.doctorapp.model;

public enum Specialization {

    ORTHO("ORTHOPEDIC"),
    PEDIA("PEDIATRICIAN"),
    PHYSICIAN("GENERAL PHYSICIAN"),
    GYNAEC("GYNAECOLOGIST"),
    NEURO("NEUROLOGIST"),
    DERMA("DERMATOLOGIST");

    private String speciality;

    private Specialization(String speciality)
    {
        this.speciality = speciality;
    }

    public String getSpeciality()
    {
        return this.speciality;
    }
}
