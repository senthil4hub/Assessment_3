package tests.rest;

import java.io.File;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import lib.rest.RESTAssuredBase;


public class TC004_PutIncident extends RESTAssuredBase{
	
	@BeforeTest//Reporting
	public void setValues() {
		testCaseName = "Put Incident (REST)";
		testDescription = "Put Incident and Verify";
		nodes = "Incident";
		authors = "Aj";
		category = "REST";
		//dataProvider
		dataFileName = "TC001";
		dataFileType = "JSON";
	}

	@Test(dataProvider = "fetchData",dependsOnMethods = "tests.rest.TC001_CreateIncident.createIncident")
	public void putIncident(File file) {		
				
		Response response = putWithBodyParam(file, "incident/"+sysID);
		response.prettyPrint();
		verifyContentType(response, "application/json");
		
		verifyResponseCode(response, 200);
		
		
		verifyContentWithKey(response, "result.short_description", "This is Rest Assured Automation framework - Makaia");
		//sysID = getContentWithKey(response, "result.sys_id");
	}

}




















