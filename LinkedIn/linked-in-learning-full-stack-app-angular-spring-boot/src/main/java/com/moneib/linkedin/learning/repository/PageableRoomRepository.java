package com.moneib.linkedin.learning.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.moneib.linkedin.learning.entity.RoomEntity;

//The second generic parameter is the type of the Id.
public interface PageableRoomRepository extends PagingAndSortingRepository<RoomEntity, Long> {
	Page<RoomEntity> findById(long Id, Pageable page);
}
