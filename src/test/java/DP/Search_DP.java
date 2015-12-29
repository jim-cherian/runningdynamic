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

public class Search_DP {
	
	@DataProvider(name="validsearch")
	public static  Iterator<String[]> dp_validsearch() throws IOException
	{
		Search_DP l = new Search_DP();
		List<String[]> ls =l.xlreader(base_class.b.wb,"Valid_Search");		
		return ls.iterator();
	}
	@DataProvider(name="invalidsearch")
	public static  Iterator<String[]> dp_invalidsearch() throws IOException
	{
		Search_DP l = new Search_DP();
		List<String[]> ls =l.xlreader(base_class.b.wb,"Invalid_Search");		
		return ls.iterator();
	}
	
	public  List<String[]> xlreader(XSSFWorkbook wb, String scriptname) throws IOException
	{
		ExcelReadWrite xl = new ExcelReadWrite(wb);
		XSSFSheet sheet = xl.Setsheet("Scenario_Search");
		int rowcount = xl.getrowcount(sheet);
		List<String[]> ls = new ArrayList<String[]>();
		
		for (int i=1;i<=rowcount;i++)
		{
			if(xl.Readvalue(sheet, i, "Scriptname").equalsIgnoreCase(scriptname))
			{				
				if(xl.Readvalue(sheet, i, "Execute_Flag").equalsIgnoreCase("Y"))
				{					
					String[] s = new String[4];
					 s[0] = xl.Readvalue(sheet, i, "TC_ID");
					 s[1] = xl.Readvalue(sheet, i, "Order");
					 s[2] = xl.Readvalue(sheet, i, "Search_Item");
					 s[3] = xl.Readvalue(sheet, i, "Exp_Res");
					 ls.add(s);
				}
			}
		}return ls;
	}

}
