package intrTrainingSeleniumWithRahul.Data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {

	
	
	public List<HashMap<String, String>> getJsonDataToMap () throws IOException
	{
		// Read json to string
	String jsonContent =	FileUtils.readFileToString(new File(System.getProperty("\\src\\test\\java\\intrTrainingSeleniumWithRahul\\Data\\Purshaseorder.json")), 
	StandardCharsets.UTF_8 );
		
		// concert Json to HashMap -- JacksonDataBind 
		ObjectMapper mapper = new ObjectMapper();
			
		List<HashMap<String, String>> data =	mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {}) ;
		return data;
	}
	
	

	
	
	
	
	
}
