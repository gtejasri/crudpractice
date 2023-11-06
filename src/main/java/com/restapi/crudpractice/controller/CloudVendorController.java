package com.restapi.crudpractice.controller;


import com.restapi.crudpractice.model.CloudVendor;
import com.restapi.crudpractice.service.CloudVendorService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {
	
	CloudVendorService cloudVendorService;
	
    public CloudVendorController(CloudVendorService cloudVendorService) {
		this.cloudVendorService = cloudVendorService;
	}

	@GetMapping("{vendorId}")
	public CloudVendor getVendorDetails(@PathVariable("vendorId") String vendorId) {
		 
    	 return cloudVendorService.getCloudVendor(vendorId);
	}
    
	@GetMapping()
	public List<CloudVendor> getAllVendorDetails() {		 
    	 return cloudVendorService.getAllCloudVendors();
	}
	
    @PostMapping
	public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
    	
		cloudVendorService.createCloudVendor(cloudVendor);
		return "Cloud vendor created successfully";
	}
    
    @PutMapping
	public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
    	
		cloudVendorService.updateCloudVendor(cloudVendor);
		return "Cloud vendor Updated successfully";
	}
    
    @DeleteMapping("{vendorId}")
    public String deleteCloudVendorDetails(@PathVariable("vendorId")String vendorId) {
    	cloudVendorService.deleteCloudVendor(vendorId);
    	return "CloudVendor Deleted Succesfully";
    	
    }
    
}
