package com.training.service;

import com.training.dao.VisitorDAO;
import com.training.model.Visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VisitorServiceImpl implements VisitorService {

    @Autowired
    private VisitorDAO visitorDAO;

    @Override
    public Visitor findByVisitorId(int visitorId) {
        Optional<Visitor> visitor = visitorDAO.findById(visitorId);
        return visitor.orElse(null);
    }

    @Override
    public Visitor findByVisitorName(String visitorName) {
        return null;
    }

    @Override
    public Visitor findByVisitorPurpose(String purpose) {
        return null;
    }

    @Override
    public Visitor findByVisitorPhone(String visitorPhone) {
        return null;
    }

    @Override
    public boolean addVisitor(Visitor visitor) {
        if (visitorDAO.existsById(visitor.getVisitorId())) {
            return false;
        }
        visitorDAO.save(visitor);
        return true;
    }

    @Override
    public boolean updateVisitor(Visitor visitor) {
        if (visitorDAO.existsById(visitor.getVisitorId())) {
            visitorDAO.save(visitor);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteVisitor(int visitorId) {
        if (visitorDAO.existsById(visitorId)) {
            visitorDAO.deleteById(visitorId);
            return true;
        }
        return false;
    }

    @Override
    public boolean checkVisitor(int visitorId) {
        return visitorDAO.existsById(visitorId);
    }

    @Override
    public List<Visitor> getVisitor() {
        return visitorDAO.findAll();
    }

    @Override
    public List<Visitor> getVisitorByPurposeMeeting() {
        return visitorDAO.findByVisitorPurposeMeeting();
    }
}





