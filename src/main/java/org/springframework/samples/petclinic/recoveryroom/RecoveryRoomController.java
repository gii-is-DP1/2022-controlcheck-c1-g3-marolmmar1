package org.springframework.samples.petclinic.recoveryroom;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RecoveryRoomController {
	
	private final RecoveryRoomService recService;
	
	@Autowired
	public RecoveryRoomController(RecoveryRoomService recService) {
		this.recService = recService;
	}
	
	@GetMapping("/recoveryroom/create")
    public String processCreationForm(Map<String, Object> model){
    	RecoveryRoom recoveryRoom = new RecoveryRoom();
    	model.put("recoveryRoom", recoveryRoom);
    	return "recoveryroom/createOrUpdateRecoveryRoomForm";
    }
	
	@PostMapping("/recoveryroom/create")
	public String processUpdateForm(@Valid RecoveryRoom recRoom,  BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "recoveryroom/createOrUpdateRecoveryRoomForm";
		}else {
			try {
				this.recService.save(recRoom);
			} catch (DuplicatedRoomNameException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return "welcome";
	}
    
}
