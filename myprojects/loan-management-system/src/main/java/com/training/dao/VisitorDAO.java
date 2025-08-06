package com.training.dao;

import com.training.model.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitorDAO extends JpaRepository <Visitor, Integer> {

    public List<Visitor> findByVisitorName(String visitorName);
    public List<Visitor> findByMobileNumber(String mobileNumber);
    public List<Visitor> findByMobileNumberAndVisitorName(String mobileNumber, String visitorName);

    public boolean deleteByMobileNumber(String mobileNumber);

    @Query("DELETE FROM Visitor v WHERE v.mobileNumber = :mobileNumber")
    void deleteVisitorByMobileNumber(@Param("mobileNumber") String mobileNumber);

    @Query("from  Visitor v WHERE v.purpose = 'Meeting'")
     public List<Visitor> findByVisitorPurposeMeeting();
}