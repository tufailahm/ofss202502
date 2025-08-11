
package com.training.controller;

import com.training.model.Visitor;
import com.training.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/visitors")
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8000" })
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
/*
    // POST - create a visitor
    @PostMapping
    public ResponseEntity<String> createVisitor(@RequestBody Visitor visitor) {
        boolean added = visitorService.addVisitor(visitor);
        return new ResponseEntity<String>("Visitor Added Successfully", HttpStatusCode.valueOf(201));
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<String> createVisitor(@RequestBody Visitor visitor) {
        visitorService.addVisitor(visitor);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("{\"message\":\"Visitor Added Successfully\"}");
    }
*/
    @PostMapping(produces = "application/json")
    public ResponseEntity<Visitor> createVisitor(@RequestBody Visitor visitor) {
       visitorService.addVisitor(visitor);
        return ResponseEntity.status(HttpStatus.CREATED).body(visitor);
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
/*
    // DELETE - by ID
    @DeleteMapping("/{visitorId}")
    public String deleteVisitorById(@PathVariable int visitorId) {
        boolean deleted = visitorService.deleteVisitor(visitorId);
        return deleted ? "Visitor deleted successfully." : "Visitor not found.";
    }
*/

    @DeleteMapping("/{visitorId}")
    public ResponseEntity<Map<String, String>> deleteVisitorById(@PathVariable int visitorId) {
        boolean deleted = visitorService.deleteVisitor(visitorId);
        Map<String, String> response = new HashMap<>();
        if (deleted) {
            response.put("message", "Visitor deleted successfully.");
            return ResponseEntity.ok(response); // HTTP 200
        } else {
            response.put("message", "Visitor not found.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
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