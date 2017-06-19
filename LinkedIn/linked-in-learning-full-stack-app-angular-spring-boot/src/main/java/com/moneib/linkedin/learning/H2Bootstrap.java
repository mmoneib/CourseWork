package com.moneib.linkedin.learning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.moneib.linkedin.learning.entity.RoomEntity;
import com.moneib.linkedin.learning.repository.RoomRepository;

@Component	//Without it the class won't execute as it won't be auto detected.
public class H2Bootstrap implements CommandLineRunner{

	@Autowired
	RoomRepository roomRepository;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Bootsrapping data: ");
		
		roomRepository.save(new RoomEntity(405,"200"));
		roomRepository.save(new RoomEntity(406,"220"));
		roomRepository.save(new RoomEntity(470,"250"));

		Iterable<RoomEntity> itr=roomRepository.findAll();
		
		System.out.println("Printing out data: ");

		for (RoomEntity roomEntity : itr) {
			System.out.println(roomEntity.getRoomNumber());
		}
	}

}
