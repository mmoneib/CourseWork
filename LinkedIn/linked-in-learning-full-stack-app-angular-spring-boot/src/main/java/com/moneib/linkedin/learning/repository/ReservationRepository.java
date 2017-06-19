package com.moneib.linkedin.learning.repository;

import org.springframework.data.repository.CrudRepository;

import com.moneib.linkedin.learning.entity.ReservationEntity;

public interface ReservationRepository extends CrudRepository<ReservationEntity, Long> {

}
