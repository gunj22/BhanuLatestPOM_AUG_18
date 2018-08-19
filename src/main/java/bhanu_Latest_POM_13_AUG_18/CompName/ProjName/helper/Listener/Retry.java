package bhanu_Latest_POM_13_AUG_18.CompName.ProjName.helper.Listener;

import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import bhanu_Latest_POM_13_AUG_18.CompName.ProjName.helper.Logger.LoggerHelper;

public class Retry implements IRetryAnalyzer {

	private Logger log = LoggerHelper.getLogger(Retry.class);
	private int retryCount = 0;
	private int maxRetryCount = 3;

	public boolean retry(ITestResult arg0) {

		if (retryCount < maxRetryCount) {
			log.info("Retrying test " + arg0.getName() + " with status " + getStatusName(arg0.getStatus()) + " for the " + (retryCount+1) + " time.");
			retryCount++;
			return true;
		}

		return false;
	}

	
	public String getStatusName(int status){
		String resultName = null;
		if(status==1){
			resultName="PASS";
		}else if(status==2){
			resultName="FAIL";
		}else if(status==3){
			resultName="SKIP";
		}
		return resultName;
	}
	
	
	
	
}
