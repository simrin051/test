package com.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.model.EarringsModel;
import com.main.model.SectionModel;

@Repository
public interface EarringsRepository  extends JpaRepository<EarringsModel, Long> {

}
