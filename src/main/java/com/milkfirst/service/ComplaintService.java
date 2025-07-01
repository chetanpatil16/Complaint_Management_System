package com.milkfirst.service;

import com.milkfirst.dto.ComplaintRequestDto;
import com.milkfirst.dto.StatusUpdateDto;
import com.milkfirst.model.Complaint;

import java.util.List;
import java.util.Map;

public interface ComplaintService {

    public Complaint addComplaint(ComplaintRequestDto complaintRequestDto);

    public Complaint updateComplaint(int id, StatusUpdateDto complaintStatusUpdateDTO);

    public List<Complaint> getAllComplaint();

    public Map<String, Integer> countStatus();

}
