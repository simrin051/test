package com.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.model.EarringsModel;
import com.main.model.NeckpiecesModel;
import org.springframework.stereotype.Repository;


@Repository
public interface NeckpiecesRepository extends JpaRepository<NeckpiecesModel, Long> {

}
