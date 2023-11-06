package com.restapi.crudpractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.restapi.crudpractice.model.CloudVendor;

public interface CloudVendorRepository extends JpaRepository<CloudVendor,String>{

}
