package assignment.StoreRestApp.servicesImpl;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import assignment.StoreRestApp.exception.StoreManagementException;
import assignment.StoreRestApp.jpaEntity.StoreDetailsEntity;
import assignment.StoreRestApp.model.StoreDetails;
import assignment.StoreRestApp.repository.StoreDetailsRepo;

@Component
public class InitialDataLoaderService implements ApplicationRunner {
	
	@Autowired
	StoreDetailsRepo storeDetailsDataSource;

	@Autowired
	ResourceLoader resourceLoader;
	
    public void run(ApplicationArguments args) {
    	 ObjectMapper objectMapper = new ObjectMapper();
		 try {
	        //read json file and convert to StoreDetails object
		
		 Resource resource = resourceLoader.getResource("classpath:TestData.json");
	        InputStream inputStream = resource.getInputStream();
	       
	            byte[] bdata = FileCopyUtils.copyToByteArray(inputStream);
	            String data = new String(bdata, StandardCharsets.UTF_8);
	            StoreDetails[] storeDetails = objectMapper.readValue(data, StoreDetails[].class);
	            
	            for(StoreDetails store :storeDetails) {
	            	StoreDetailsEntity entity = new StoreDetailsEntity();
	            	//entity.setId(store.getId());
	            	entity.setType(store.getType());
	            	entity.setName(store.getName());
	            	entity.setAddress(store.getAddress());
	            	entity.setAddress2(store.getAddress2());
	            	entity.setCity(store.getCity());
	            	entity.setState(store.getState());
	            	entity.setZip(store.getZip());
	            	entity.setHours(store.getHours());
	            	
					if(store.getServices()!=null && !store.getServices().isEmpty()) {
	            	StringBuilder b = new StringBuilder();
	            	for (String s :store.getServices()) {
	            		b.append(s+",");
	            	}
	            	entity.setServices(b.toString().substring(0, b.length()-1));
	            	storeDetailsDataSource.save(entity);
					}
	            	
	            }
			} catch (IOException e) {
				throw new StoreManagementException(e.getMessage(), "1001");
			} 
		 
    }

}
