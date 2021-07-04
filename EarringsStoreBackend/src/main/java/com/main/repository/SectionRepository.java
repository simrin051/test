package com.main.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.main.model.SectionModel;

@Repository
public interface SectionRepository extends JpaRepository<SectionModel, Long> {

	 
}
