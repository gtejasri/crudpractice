package com.restapi.crudpractice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.restapi.crudpractice.exception.CloudVendorNotFoundException;
import com.restapi.crudpractice.model.CloudVendor;
import com.restapi.crudpractice.repository.CloudVendorRepository;

@Service
public class CloudVendorServiceImp implements CloudVendorService {

	CloudVendorRepository cloudVendorRepository;
	
	public CloudVendorServiceImp(CloudVendorRepository cloudVendorRepository) {
		this.cloudVendorRepository = cloudVendorRepository;
	}
	
	@Override
	public String createCloudVendor(CloudVendor cloudVendor) {
		cloudVendorRepository.save(cloudVendor);
		return "Success";
	}

	@Override
	public String updateCloudVendor(CloudVendor cloudVendor) {
		cloudVendorRepository.save(cloudVendor);
		return "Success";
	}

	@Override
    public String deleteCloudVendor(String cloudVendorId) {
        // More Business Logic
        cloudVendorRepository.deleteById(cloudVendorId);
        return "Success";
    }

	@Override
	public CloudVendor getCloudVendor(String cloudVendorId) {	
		if(cloudVendorRepository.findById(cloudVendorId).isEmpty())
			throw new CloudVendorNotFoundException("Requested Cloud Vendor does not exist");
		return cloudVendorRepository.findById(cloudVendorId).get();
	}

	@Override
	public List<CloudVendor> getAllCloudVendors() {
		return cloudVendorRepository.findAll();
	}

}
