package com.milkfirst.controller;

import com.milkfirst.dto.ComplaintRequestDto;
import com.milkfirst.dto.StatusUpdateDto;
import com.milkfirst.model.Complaint;
import com.milkfirst.service.ComplaintService;
import com.milkfirst.service.serviceImpl.ComplaintServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Complaints")
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;

    @PostMapping("/RaiseComplaint")
    public ResponseEntity<Complaint> addComplaints(@Valid @RequestBody ComplaintRequestDto complaintRequestDto){

        return new ResponseEntity<>(complaintService.addComplaint(complaintRequestDto), HttpStatus.CREATED);
    }

    @PutMapping("/UpdateComplaintStatus/{id}")
    public ResponseEntity<Complaint> updateStatus(@PathVariable("id") int id,  @RequestBody StatusUpdateDto statusUpdateDto){

        return ResponseEntity.ok(complaintService.updateComplaint(id,statusUpdateDto));
    }

    @GetMapping("/getAllComplaints")
    public ResponseEntity<List<Complaint>> getAllComplaints(){
        return ResponseEntity.ok(complaintService.getAllComplaint());
    }

    @GetMapping("/status-count")
    public Map<String, Integer> getStatusCounts() {
        return complaintService.countStatus();
    }
}

