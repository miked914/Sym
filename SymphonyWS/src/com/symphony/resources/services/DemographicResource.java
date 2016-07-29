package com.symphony.resources.services;

import javax.ws.rs.Path;

@Path("/demo")
public class DemographicResource {
	
	@Path("/appinfo")
	public ApplicantResources getApplicantResource() throws Exception{
		return new ApplicantResources();
	}
	
	@Path("/addressinfo")
	public ApplicantAddressRes getAddressResource() throws Exception{
		return new ApplicantAddressRes();
	}	
}

