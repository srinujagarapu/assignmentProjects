package assignment.StoreRestApp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import assignment.StoreRestApp.model.StoreDetails;
import assignment.StoreRestApp.services.StoreManagementService;

/**
 * 
 * @author JSRINU
 * 
 *         This controller class contains all required rest api call's for
 *         StoreManagement service
 *
 */

@RestController()
public class StoreManagementController {

	Logger logger = LoggerFactory.getLogger(StoreManagementController.class);

	@Autowired
	StoreManagementService storeManagementService;

	@GetMapping(value = "/details")
	public ResponseEntity<?> getAllStoreDetails() {
		logger.info("Start getAllStoreDetails Service");

		try {

			List<StoreDetails> results = storeManagementService.getStoreDetails();
			logger.info("End getAllStoreDetails service");
			return ResponseEntity.ok(results);

		} catch (Exception e) {
			logger.error("Error in  getAllStoreDetails service " + e.getMessage());
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	@PostMapping(value = "/details")
	public ResponseEntity<?> createStoreDetails(@RequestBody String body) {
		try {
			logger.info("Start createStoreDetails service");
			if (body != null) {
				storeManagementService.createStoreDetails(body);
				logger.info("End createStoreDetails service");
				return ResponseEntity.ok("Succesful");
			} else {
				logger.error("createStoreDetails service invalid request body "+body);
				return new ResponseEntity("Invalid store details update Request " + body, HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			logger.error("Error in  createStoreDetails service "+e.getMessage());
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	@PutMapping(value = "/details/{id}")
	public ResponseEntity<?> updateStoreDetails(@RequestBody String body, @PathVariable Long id) {
		try {
			if (body != null) {
				logger.info("Start updateStoreDetails service");
				storeManagementService.updateStoreDetails(body);
				logger.info("End updateStoreDetails service");
				return ResponseEntity.ok("Succesful");
			} else {
				logger.error("updateStoreDetails service invalid request body "+body);
				return new ResponseEntity("Invalid store details update Request " + body, HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			logger.error("Error in updateStoreDetails service  "+e.getMessage());
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	@DeleteMapping(value = "/details/{id}")
	public ResponseEntity<?> deleteStoreDetails(@PathVariable Long id) {
		try {
			if (id != null) {
				logger.info("Start deleteStoreDetails service");
				storeManagementService.deleteStoreDetails(id);
				logger.info("End deleteStoreDetails service");
				return ResponseEntity.ok("Succesful");
			} else {
				logger.error(" deleteStoreDetails service StoreId not provided");
				return new ResponseEntity("Invalid storedetails delete Request " + id, HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			logger.error("Error in deleteStoreDetails service");
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

}
