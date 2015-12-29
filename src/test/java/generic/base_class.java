package generic;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeTest;

public class base_class {
	
	public XSSFWorkbook wb = null;
	public static base_class b;
	@BeforeTest(groups={"SmokeTest","Regression"})
	public void execute_beforetest() throws IOException
	{
		System.out.println("Test");
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Test_Data.xlsx");
		b = new base_class();
		b.wb=new XSSFWorkbook(fis);
		if(b.wb==null)
		{
			System.out.println("ISNULL");
		}
	}

}
