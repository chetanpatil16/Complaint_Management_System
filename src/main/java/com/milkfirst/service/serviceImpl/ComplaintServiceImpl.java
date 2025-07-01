package com.milkfirst.service.serviceImpl;

import com.milkfirst.Repo.ComplaintRepo;
import com.milkfirst.dto.ComplaintRequestDto;
import com.milkfirst.dto.StatusUpdateDto;
import com.milkfirst.exception.ComplaintNotFound;
import com.milkfirst.model.Complaint;
import com.milkfirst.model.Status;
import com.milkfirst.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    @Autowired
    private ComplaintRepo complaintRepo;

    @Override
    public Complaint addComplaint(ComplaintRequestDto complaintRequestDto) {
        Complaint complaint=new Complaint();

        complaint.setCustomerName(complaintRequestDto.getCustomerName());
        complaint.setIssueDescription(complaintRequestDto.getIssueDescription());
        complaint.setStaus(Status.OPEN);
        complaint.setRaisedOn(LocalDateTime.now());

        return complaintRepo.save(complaint);
    }

    public Complaint updateComplaint(int id, StatusUpdateDto complaintStatusUpdateDTO){
        Complaint complaint=complaintRepo.findById(id).orElseThrow(()-> new ComplaintNotFound("Complaint Not Found"));

       complaint.setStaus(complaintStatusUpdateDTO.getStatus());

       if(complaintStatusUpdateDTO.getStatus() == Status.RESOLVED) {
           complaint.setResolvedOn(LocalDateTime.now());

           long Hours = Duration.between(complaint.getRaisedOn(), complaint.getResolvedOn()).toHours();
           complaint.setDurationInHours(Hours);

       }

//       if(complaintStatusUpdateDTO.getStatus()== Status.IN_PROGRESS || complaintStatusUpdateDTO.getStatus() == Status.OPEN){

//       }else{
//           throw new InvalidStatus("Invalid Status");
//       }
//
        return complaintRepo.save(complaint);
    }

    @Override
    public List<Complaint> getAllComplaint() {
        return complaintRepo.findAll();
    }

    @Override
    public Map<String, Integer> countStatus() {
        Map<String, Integer> map=new HashMap<>();

        for(Status s: Status.values()){
            map.put(s.name(), complaintRepo.countByStatus(s));
        }
        return map;
    }
}
