package com.milkfirst.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

@Entity
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int complaintId;

    @NotBlank
    private String customerName;

    private String issueDescription;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime raisedOn;

    private LocalDateTime resolvedOn;

    public int getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(int complaintId) {
        this.complaintId = complaintId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    public LocalDateTime getRaisedOn() {
        return raisedOn;
    }

    public void setRaisedOn(LocalDateTime raisedOn) {
        this.raisedOn = raisedOn;
    }

    public LocalDateTime getResolvedOn() {
        return resolvedOn;
    }

    public void setResolvedOn(LocalDateTime resolvedOn) {
        this.resolvedOn = resolvedOn;
    }

    public Status getStaus() {
        return status;
    }

    public void setStaus(Status staus) {
        this.status = staus;
    }

    @Override
    public String toString() {
        return "Complaint{" +
                "complaintId=" + complaintId +
                ", customerName='" + customerName + '\'' +
                ", issueDescription='" + issueDescription + '\'' +
                ", staus=" + status +
                ", raisedOn=" + raisedOn +
                ", resolvedOn=" + resolvedOn +
                '}';
    }
}
