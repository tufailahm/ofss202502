
package com.training.controller;

import com.training.model.Visitor;
import com.training.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visitors")
public class VisitorController {

    @Autowired
    private VisitorService visitorService;

    // GET a single visitor by ID
    @GetMapping("/{visitorId}")
    public Visitor getVisitorById(@PathVariable int visitorId) {
        return visitorService.findByVisitorId(visitorId);
    }

    // GET visitor by name
    @GetMapping("/search/{visitorName}")
    public Visitor getVisitorByName(@PathVariable String visitorName) {
        return visitorService.findByVisitorName(visitorName);
    }

    // GET visitor by purpose
    @GetMapping("/search/purpose/{purpose}")
    public Visitor getVisitorByPurpose(@PathVariable String purpose) {
        return visitorService.findByVisitorPurpose(purpose);
    }

    // GET visitor by mobile number
    @GetMapping("/mobilenumber/{mobileNumber}")
    public Visitor getVisitorByPhone(@PathVariable String mobileNumber) {
        return visitorService.findByVisitorPhone(mobileNumber);
    }

    // POST - create a visitor
    @PostMapping
    public String createVisitor(@RequestBody Visitor visitor) {
        boolean added = visitorService.addVisitor(visitor);
        return added ? "Visitor added successfully." : "Visitor already exists.";
    }

    // PUT - update a visitor
    @PutMapping
    public String updateVisitor(@RequestBody Visitor visitor) {
        boolean updated = visitorService.updateVisitor(visitor);
        return updated ? "Visitor updated successfully." : "Visitor not found.";
    }

    // PUT - update mobile number (optional custom logic)
    @PutMapping("/{visitorId}/{newMobileNumber}")
    public String updateMobileNumber(@PathVariable int visitorId, @PathVariable String newMobileNumber) {
        Visitor visitor = visitorService.findByVisitorId(visitorId);
        if (visitor != null) {
            visitor.setMobileNumber(newMobileNumber); // Ensure your entity has this setter
            visitorService.updateVisitor(visitor);
            return "Mobile number updated.";
        }
        return "Visitor not found.";
    }

    // DELETE - by ID
    @DeleteMapping("/{visitorId}")
    public String deleteVisitorById(@PathVariable int visitorId) {
        boolean deleted = visitorService.deleteVisitor(visitorId);
        return deleted ? "Visitor deleted successfully." : "Visitor not found.";
    }

    // DELETE - by mobile number
    @DeleteMapping("/mobilenumber/{mobileNumber}")
    public String deleteVisitorByMobile(@PathVariable String mobileNumber) {
        Visitor visitor = visitorService.findByVisitorPhone(mobileNumber);
        if (visitor != null) {
            visitorService.deleteVisitor(visitor.getVisitorId());
            return "Visitor deleted by mobile number.";
        }
        return "Visitor not found.";
    }
    @GetMapping
    public ResponseEntity<?> getAllVisitors() {
        List<Visitor> visitors = visitorService.getVisitor();
        if (visitors.isEmpty()) {
            return new ResponseEntity<>("No visitors found", HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(visitors, HttpStatus.OK);
        }
    }

    @GetMapping("meeting")
    public ResponseEntity<?> getAllVisitorsMeeting() {
        List<Visitor> visitors = visitorService.getVisitorByPurposeMeeting();
        if (visitors.isEmpty()) {
            return new ResponseEntity<>("No visitors found", HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(visitors, HttpStatus.OK);
        }
    }
}