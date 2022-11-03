package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.bytebuddy.implementation.bytecode.Throw;

@Service
public class RecoveryRoomService {
    
	private RecoveryRoomRepository recRepo;
	
	@Autowired
	public RecoveryRoomService(RecoveryRoomRepository recRepo) {
		this.recRepo = recRepo;
	}
	
	public List<RecoveryRoom> getAll(){
        return this.recRepo.findAll();
    }

    public List<RecoveryRoomType> getAllRecoveryRoomTypes(){
        return this.recRepo.findAllRecoveryRoomTypes();
    }

    public RecoveryRoomType getRecoveryRoomType(String typeName) {
        return this.recRepo.getRecoveryRoomType(typeName);
    }

    public RecoveryRoom save(RecoveryRoom p) throws DuplicatedRoomNameException {
       /* 
    	for(RecoveryRoomType type : recRepo.getRoomsByname(p.name)) {
    		if (type.equals(p.roomType)) {
    			
			}
    	}
    	*/
    	return null;       
    }

    
}
