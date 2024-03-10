package com.doctorapp.model;

public class Doctor {

    private Integer doctorId;
    private String doctorName;
    private String speciality;
    private double fee;
    private int rating;
    private int experience;

    public Doctor() {
    }

    public Doctor(Integer doctorId, String doctorName, String speciality, double fee, int rating, int experience) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.speciality = speciality;
        this.fee = fee;
        this.rating = rating;
        this.experience = experience;
    }

    public Doctor(String doctorName, String speciality, double fee, int rating, int experience) {
        this.doctorName = doctorName;
        this.speciality = speciality;
        this.fee = fee;
        this.rating = rating;
        this.experience = experience;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorId=" + doctorId +
                ", doctorName='" + doctorName + '\'' +
                ", speciality='" + speciality + '\'' +
                ", fee=" + fee +
                ", rating=" + rating +
                ", experience=" + experience +
                '}';
    }
}
