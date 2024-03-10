package com.doctorapp.repository;

import com.doctorapp.model.Doctor;
import com.doctorapp.util.DoctorDb;
import com.doctorapp.util.Queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DoctorRepositoryImpl implements IDoctorRepository {
    @Override
    public void addDoctor(Doctor doctor) {
        try (Connection connection = DoctorDb.openConnection();
             PreparedStatement statement = connection.prepareStatement(Queries.INSERTQUERY);
        ) {
            statement.setString(1, doctor.getDoctorName());
            statement.setString(2, doctor.getSpeciality());
            statement.setInt(3, doctor.getExperience());
            statement.setInt(4, doctor.getRating());
            statement.setDouble(5, doctor.getFee());
            // call execute
            boolean result = statement.execute();
            System.out.println("one row inserted " + !result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateDoctor(int doctorId, double fee) {
        try (Connection connection = DoctorDb.openConnection();
             PreparedStatement statement = connection.prepareStatement(Queries.UPDATEQUERY);
        ) {
            statement.setInt(2, doctorId);
            statement.setDouble(1, fee);
            int result = statement.executeUpdate();
            System.out.println("one row updated " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDoctor(int doctorId) {
        try (Connection connection = DoctorDb.openConnection();
             PreparedStatement statement = connection.prepareStatement(Queries.DELETEQUERY);
        ) {
            statement.setInt(2, doctorId);
            int result = statement.executeUpdate();
            System.out.println("one row deleted " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Doctor findById(int doctorId) {

        List<Doctor> doctorList;
        doctorList = new ArrayList<>();

        try (Connection connection = DoctorDb.openConnection();
             PreparedStatement statement = connection.prepareStatement(Queries.FINDBYID);
             ResultSet resultSet = statement.executeQuery();
        ) {
            while (resultSet.next()) {
                String doctorName = resultSet.getString("doctor_name");
                String speciality = resultSet.getString("speciality");
                int experience = resultSet.getInt("experience");
                int rating = resultSet.getInt("rating");
                doctorId = resultSet.getInt("doctor_id");
                double fee = resultSet.getDouble("fee");
                Doctor doctor = new Doctor(doctorId, doctorName, speciality, fee, rating, experience);
                doctorList.add(doctor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (Doctor) doctorList;
    }

    @Override
    public List<Doctor> findAll() {
        List<Doctor> doctorList;
        doctorList = new ArrayList<>();

        try (Connection connection = DoctorDb.openConnection();
             PreparedStatement statement = connection.prepareStatement(Queries.FINDALLQUERY);
             ResultSet resultSet = statement.executeQuery();
        ) {
            while (resultSet.next()) {
                String doctorName = resultSet.getString("doctor_name");
                String speciality = resultSet.getString("speciality");
                int experience = resultSet.getInt("experience");
                int rating = resultSet.getInt("rating");
                int doctorId = resultSet.getInt("doctor_id");
                double fee = resultSet.getDouble("fee");
                Doctor doctor = new Doctor(doctorId, doctorName, speciality, fee, rating, experience);
                doctorList.add(doctor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doctorList;
    }

    @Override
    public List<Doctor> findBySpeciality(String speciality) {

        List<Doctor> doctorList = new ArrayList<>();
        try (Connection connection = DoctorDb.openConnection();
             PreparedStatement statement = connection.prepareStatement(Queries.FINDBYSPECIALITY);
        ) {
            statement.setString(1, speciality);
            try (ResultSet resultSet = statement.executeQuery();) {
                while (resultSet.next()) {
                    String doctorName = resultSet.getString("doctor_name");
                    int experience = resultSet.getInt("experience");
                    int rating = resultSet.getInt("ratings");
                    int doctorId = resultSet.getInt("doctor_id");
                    double fee = resultSet.getDouble("fees");
                    Doctor doctor = new Doctor();
                    doctor.setDoctorName(doctorName);
                    doctor.setSpeciality(speciality);
                    doctor.setExperience(experience);
                    doctor.setRating(rating);
                    doctor.setFee(fee);
                    doctor.setDoctorId(doctorId);
                    doctorList.add(doctor);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doctorList;
    }

    @Override
    public List<Doctor> findBySpecialityAndExp(String speciality, int experience) {

        List<Doctor> doctorList = new ArrayList<>();
        try (Connection connection = DoctorDb.openConnection();
             PreparedStatement statement =
                     connection.prepareStatement(Queries.FINDBYSPECANDEXP);
        ) {
            statement.setString(1, speciality);
            statement.setInt(2,experience);
            try (ResultSet resultSet = statement.executeQuery();) {
                while (resultSet.next()) {
                    Doctor doctor = new Doctor();
                    doctor.setDoctorName(resultSet.getString("doctor_name"));
                    doctor.setSpeciality(resultSet.getString("speciality"));
                    doctor.setExperience(resultSet.getInt("experience"));
                    doctor.setRating(resultSet.getInt("rating"));
                    doctor.setFee(resultSet.getDouble("fee"));
                    doctor.setDoctorId(resultSet.getInt("doctor_id"));
                    doctorList.add(doctor);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doctorList;
    }

    @Override
    public List<Doctor> findBySpecialityAndLessFees(String speciality, double fee) {

        List<Doctor> doctorList = new ArrayList<>();
        try (Connection connection = DoctorDb.openConnection();
             PreparedStatement statement =
                     connection.prepareStatement(Queries. FINDBYSPECANDFEES);
        ) {
            statement.setString(1, speciality);
            statement.setDouble(2, fee);
            try (ResultSet resultSet = statement.executeQuery();) {
                while (resultSet.next()) {
                    Doctor doctor = new Doctor();
                    doctor.setDoctorName(resultSet.getString("doctor_name"));
                    doctor.setSpeciality(resultSet.getString("speciality"));
                    doctor.setExperience(resultSet.getInt("experience"));
                    doctor.setRating(resultSet.getInt("rating"));
                    doctor.setFee(resultSet.getDouble("fee"));
                    doctor.setDoctorId(resultSet.getInt("doctor_id"));
                    doctorList.add(doctor);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doctorList;
    }

    @Override
    public List<Doctor> findBySpecialityAndRatings(String speciality, int rating) {

        List<Doctor> doctorList = new ArrayList<>();
        try (Connection connection = DoctorDb.openConnection();
             PreparedStatement statement =
                     connection.prepareStatement(Queries.FINDBYSPECANDRATINGS);
        ) {
            statement.setString(1, speciality);
            statement.setInt(2, rating);
            try (ResultSet resultSet = statement.executeQuery();) {
                while (resultSet.next()) {
                    Doctor doctor = new Doctor();
                    doctor.setDoctorName(resultSet.getString("doctor_name"));
                    doctor.setSpeciality(resultSet.getString("speciality"));
                    doctor.setExperience(resultSet.getInt("experience"));
                    doctor.setRating(resultSet.getInt("rating"));
                    doctor.setFee(resultSet.getDouble("fee"));
                    doctor.setDoctorId(resultSet.getInt("doctor_id"));
                    doctorList.add(doctor);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doctorList;
    }

    @Override
    public List<Doctor> findBySpecialityAndNameContains(String speciality, String doctorName) {
        List<Doctor> doctorList = new ArrayList<>();
        try (Connection connection = DoctorDb.openConnection();
             PreparedStatement statement =
                     connection.prepareStatement(Queries.FINDBYSPECANDNAME);
        ) {
            statement.setString(1, speciality);
            statement.setString(2, "%" + doctorName + "%");
            try (ResultSet resultSet = statement.executeQuery();) {
                while (resultSet.next()) {
                    Doctor doctor = new Doctor();
                    doctor.setDoctorName(resultSet.getString("doctor_name"));
                    doctor.setSpeciality(resultSet.getString("speciality"));
                    doctor.setExperience(resultSet.getInt("experience"));
                    doctor.setRating(resultSet.getInt("rating"));
                    doctor.setFee(resultSet.getDouble("fee"));
                    doctor.setDoctorId(resultSet.getInt("doctor_id"));
                    doctorList.add(doctor);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doctorList;
    }
}
