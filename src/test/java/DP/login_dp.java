package DP;

import generic.ExcelReadWrite;
import generic.base_class;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class login_dp {
	
	@DataProvider(name="invalidlogin")
	public static  Iterator<String[]> dp_invalidlogin() throws IOException
	{
		login_dp l = new login_dp();
		List<String[]> ls =l.xlreader(base_class.b.wb,"Invalid_Login_test");		
		return ls.iterator();
	}
	@DataProvider(name="validlogin")
	public static  Iterator<String[]> dp_validlogin() throws IOException
	{
		login_dp l = new login_dp();
		List<String[]> ls =l.xlreader(base_class.b.wb,"Valid_Login_test");		
		return ls.iterator();
	}
	
	public  List<String[]> xlreader(XSSFWorkbook wb, String scriptname) throws IOException
	{
		ExcelReadWrite xl = new ExcelReadWrite(wb);
		XSSFSheet sheet = xl.Setsheet("Scenario_login");
		int rowcount = xl.getrowcount(sheet);
		List<String[]> ls = new ArrayList<String[]>();
		
		for (int i=1;i<=rowcount;i++)
		{
			if(xl.Readvalue(sheet, i, "Scriptname").equalsIgnoreCase(scriptname))
			{				
					if(xl.Readvalue(sheet, i, "Execute_Flag").equalsIgnoreCase("Y"))
				{					
					String[] s = new String[5];
					 s[0] = xl.Readvalue(sheet, i, "TC_ID");
					 s[1] = xl.Readvalue(sheet, i, "Order");
					 s[2] = xl.Readvalue(sheet, i, "Uname");
					 s[3] = xl.Readvalue(sheet, i, "Pwd");
					 s[4] = xl.Readvalue(sheet, i, "Exp_Res");
					 ls.add(s);
				}
			}
		}return ls;
	}

}
