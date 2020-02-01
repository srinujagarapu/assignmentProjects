package assignment.StoreRestApp.services;

import java.util.List;



import assignment.StoreRestApp.model.StoreDetails;

public interface StoreManagementService {
	
	public List<StoreDetails> getStoreDetails();
	
	public void createStoreDetails(String updatedStore);
	
	public void updateStoreDetails(String updatedStore);
	
	public String deleteStoreDetails(Long storeId);

}
