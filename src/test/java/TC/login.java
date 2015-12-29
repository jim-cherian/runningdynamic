package TC;

import generic.base_class;

import org.testng.annotations.Test;

public class login extends base_class {
	@Test(dataProvider="invalidlogin",dataProviderClass=DP.login_dp.class)
	public void test1(String TC_ID, String Order, String Uname, String Pwd, String Exp_Result)
	{
		System.out.println(Uname);
	}
	
	@Test(dataProvider="validlogin",dataProviderClass=DP.login_dp.class,groups={"SmokeTest"})
	public void test2(String TC_ID, String Order,String Uname, String Pwd, String Exp_Result)
	{
		System.out.println(Uname);
	}
}
