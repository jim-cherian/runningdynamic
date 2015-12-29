package TC;

import generic.base_class;

import org.testng.annotations.Test;

public class Search extends base_class {
	
	@Test(dataProvider="invalidsearch",dataProviderClass=DP.Search_DP.class)
	public void test1(String TC_ID, String Order,String Search_Item, String Exp_Result)
	{
		System.out.println(Search_Item);
	}
	
	@Test(dataProvider="validsearch",dataProviderClass=DP.Search_DP.class,groups={"SmokeTest"})
	public void test2(String TC_ID, String Order,String Search_Item, String Exp_Result)
	{
		System.out.println(Search_Item);
	}
}
