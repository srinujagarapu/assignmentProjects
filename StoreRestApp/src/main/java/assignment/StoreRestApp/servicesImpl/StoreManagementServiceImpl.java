package assignment.StoreRestApp.servicesImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.fasterxml.jackson.databind.ObjectMapper;

import assignment.StoreRestApp.exception.StoreManagementException;
import assignment.StoreRestApp.jpaEntity.StoreDetailsEntity;
import assignment.StoreRestApp.model.StoreDetails;
import assignment.StoreRestApp.repository.StoreDetailsRepo;
import assignment.StoreRestApp.services.StoreManagementService;

@Service
public class StoreManagementServiceImpl implements StoreManagementService{

	@Autowired
	StoreDetailsRepo storeDetailsRepo;

	public List<StoreDetails> getStoreDetails() {
		List<StoreDetails> storeDetailsList = new ArrayList<>();
		List<StoreDetailsEntity> entityList = storeDetailsRepo.findAll();
		for(StoreDetailsEntity entity : entityList) {
			StoreDetails storeDetails = new StoreDetails();
			storeDetails.setId(entity.getId());
			storeDetails.setType(entity.getType());
			storeDetails.setName(entity.getName());
			storeDetails.setAddress(entity.getAddress());
			storeDetails.setAddress2(entity.getAddress2());
			storeDetails.setCity(entity.getCity());
			storeDetails.setState(entity.getState());
			storeDetails.setZip(entity.getZip());
			storeDetails.setHours(entity.getHours());
			List<String> services = new ArrayList<>();
			for (String service : entity.getServices().split(",")) {
				services.add(service);	
			}
			storeDetails.setServices(services);
			storeDetailsList.add(storeDetails);
		}
		return storeDetailsList;
	}
	
	public void createStoreDetails(String updatedStore)  {

		try {
			ObjectMapper objectMapper = new ObjectMapper();

			StoreDetails storeDetails = objectMapper.readValue(updatedStore, StoreDetails.class);
			
				StoreDetailsEntity entity = new StoreDetailsEntity();
				entity.setType(storeDetails.getType());
				entity.setName(storeDetails.getName());
				entity.setAddress(storeDetails.getAddress());
				entity.setAddress2(storeDetails.getAddress2());
				entity.setCity(storeDetails.getCity());
				entity.setState(storeDetails.getState());
				entity.setZip(storeDetails.getZip());
				entity.setHours(storeDetails.getHours());

				if (storeDetails.getServices() != null && !storeDetails.getServices().isEmpty()) {
					StringBuilder b = new StringBuilder();
					for (String s : storeDetails.getServices()) {
						b.append(s + ",");
					}
					entity.setServices(  b.toString().substring(0, b.length() - 1));
					storeDetailsRepo.save(entity);

				} else {
					throw new StoreManagementException("Store Details not available in database", "1003");

				}
			
		} catch (IOException e) {
			throw new StoreManagementException(e.getMessage(), "1002");
		}

		
		
	}

	public void updateStoreDetails(String updatedStore)  {

		try {
			ObjectMapper objectMapper = new ObjectMapper();

			StoreDetails storeDetails = objectMapper.readValue(updatedStore, StoreDetails.class);
			Optional<StoreDetailsEntity> storeEntity = storeDetailsRepo.findById(storeDetails.getId());
			if (storeEntity.isPresent()) {
				StoreDetailsEntity entity = storeEntity.get();
				entity.setType(storeDetails.getType());
				entity.setName(storeDetails.getName());
				entity.setAddress(storeDetails.getAddress());
				entity.setAddress2(storeDetails.getAddress2());
				entity.setCity(storeDetails.getCity());
				entity.setState(storeDetails.getState());
				entity.setZip(storeDetails.getZip());
				entity.setHours(storeDetails.getHours());

				if (storeDetails.getServices() != null && !storeDetails.getServices().isEmpty()) {
					StringBuilder b = new StringBuilder();
					for (String s : storeDetails.getServices()) {
						b.append(s + ",");
					}
					entity.setServices(  b.toString().substring(0, b.length() - 1));
					storeDetailsRepo.save(entity);

				} else {
					throw new StoreManagementException("Store Details not available in database", "1003");

				}
			}
		} catch (IOException e) {
			throw new StoreManagementException(e.getMessage(), "1002");
		}

		
	}

	public String deleteStoreDetails(Long storeId) {
		Optional<StoreDetailsEntity> storeEntity = storeDetailsRepo.findById(storeId);
		if (storeEntity.isPresent()) {
		storeDetailsRepo.deleteById(storeId);
		}
		else {
			throw new StoreManagementException("Store Details not available in database", "1003");

		}
		return "";
	}

}
