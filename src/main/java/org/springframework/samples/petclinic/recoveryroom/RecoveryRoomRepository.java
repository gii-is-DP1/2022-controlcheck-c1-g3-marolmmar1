package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RecoveryRoomRepository extends CrudRepository<RecoveryRoom, Integer>{
    
	@Query("SELECT p FROM RecoveryRoomType p")
    List<RecoveryRoomType> findAllRecoveryRoomTypes();
	
	@Query("SELECT p FROM RecoveryRoom p")
	List<RecoveryRoom> findAll();
	
	@Query("SELECT p FROM RecoveryRoomType p WHERE p.name = :name")
	RecoveryRoomType getRecoveryRoomType(String name);
	
	@Query("SELECT p.roomType FROM RecoveryRoom p WHERE p.name = :name")
	List<RecoveryRoomType> getRoomsByname(String name);
	
    Optional<RecoveryRoom> findById(int id);
    //RecoveryRoom save(RecoveryRoom p);
    
}
