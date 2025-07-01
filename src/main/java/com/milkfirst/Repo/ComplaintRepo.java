package com.milkfirst.Repo;

import com.milkfirst.dto.StatusUpdateDto;
import com.milkfirst.model.Complaint;
import com.milkfirst.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplaintRepo extends JpaRepository<Complaint, Integer> {

    public int countByStatus(Status status);
}
