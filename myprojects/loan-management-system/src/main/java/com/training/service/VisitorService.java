package com.training.service;

import com.training.model.Visitor;

import java.util.List;

public interface VisitorService {
    public Visitor findByVisitorId(int visitorId);
    public Visitor findByVisitorName(String visitorName);
    public Visitor findByVisitorPurpose(String purpose);
    public Visitor findByVisitorPhone(String visitorPhone);

    //Update-delete-save
    public boolean addVisitor(Visitor visitor);
    public boolean updateVisitor(Visitor visitor);
    public boolean deleteVisitor(int visitorId);
    public boolean checkVisitor(int visitorId);

    public List<Visitor> getVisitor();
    public List<Visitor> getVisitorByPurposeMeeting();

}
