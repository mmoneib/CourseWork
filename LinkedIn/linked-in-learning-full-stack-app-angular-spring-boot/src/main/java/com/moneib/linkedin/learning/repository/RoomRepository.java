package com.moneib.linkedin.learning.repository;

import org.springframework.data.repository.CrudRepository;

import com.moneib.linkedin.learning.entity.RoomEntity;

public interface RoomRepository extends CrudRepository<RoomEntity, Long> {

	RoomEntity findById(Long id);
}
