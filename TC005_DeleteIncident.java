package tests.rest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import lib.rest.RESTAssuredBase;


public class TC005_DeleteIncident extends RESTAssuredBase{
	
	@BeforeTest//Reporting
	public void setValues() {
		testCaseName = "Delete Incident (REST)";
		testDescription = "Delete Incident and Verify";
		nodes = "Incident";
		authors = "SR";
		category = "REST";
	
	}

	@Test(dependsOnMethods = "tests.rest.TC004_PutIncident.putIncident")
	public void deleteIncident() {		
				
		Response response = delete("incident/"+sysID);
		response.prettyPrint();
		//verifyContentType(response, "application/json");
		verifyResponseCode(response, 204);

		
		
	
	}

}




















