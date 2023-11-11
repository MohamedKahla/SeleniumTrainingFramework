package intrTrainingSeleniumWithRahul.TestComponenet;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer  {

	int count = 0;
	int numberOfRetry = 1;
	
	@Override
	public boolean retry(ITestResult result) {
	
		if ( count < numberOfRetry  )
		{
			count++;
			return true;
		}
		
		return false;
	}
		
}
