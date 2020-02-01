package assignment.StoreRestApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import assignment.StoreRestApp.exception.StoreManagementException;
import assignment.StoreRestApp.services.StoreManagementService;
import assignment.StoreRestApp.servicesImpl.StoreManagementServiceImpl;

/**
 * 
 * @author JSRINU
 * 
 * This controller class contains all required rest api call's for StoreManagement service
 *
 */

@RestController()
public class StoreManagementController {
	
	@Autowired
	StoreManagementService storeManagementService;
	
	@GetMapping(value="/details")
	public ResponseEntity<?> getAllStoreDetails(){
		
		return ResponseEntity.ok(storeManagementService.getStoreDetails());
	}
	
	@PostMapping(value="/details")
	public ResponseEntity<?> createStoreDetails(@RequestBody String body ){
		try{
			if(body!=null) {
			storeManagementService.createStoreDetails(body);
			return ResponseEntity.ok("Succesful");
			}else{
				return new ResponseEntity("Invalid store details update Request "+body,HttpStatus.BAD_REQUEST);
			}
		}catch(Exception e) {
			return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
	}
	@PutMapping(value="/details/{id}")
	public ResponseEntity<?> updateStoreDetails(@RequestBody String body, @PathVariable Long id ){
		try{
			if(body!=null) {
			storeManagementService.updateStoreDetails(body);
			return ResponseEntity.ok("Succesful");
			}else{
				return new ResponseEntity("Invalid store details update Request "+body,HttpStatus.BAD_REQUEST);
			}
		}catch(Exception e) {
			return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@DeleteMapping(value="/details/{id}")
	public ResponseEntity<?> deleteStoreDetails(@PathVariable Long id){
		try{
			if(id!=null) {
			storeManagementService.deleteStoreDetails(id);
			return ResponseEntity.ok("Succesful");
			}else{
				return new ResponseEntity("Invalid storedetails delete Request "+id,HttpStatus.BAD_REQUEST);
			}
		}catch(Exception e) {
			return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}

}
