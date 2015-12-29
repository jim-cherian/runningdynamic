package driver;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;



public class DriverClass {
	public static void main(String[] args) {
		String login = "TC.login";
		String Search = "TC.Search";
		XmlSuite suite = new XmlSuite();
		suite.setName("Jim");		 
		XmlTest test = new XmlTest(suite);
		test.setName("JimTest");
		List<String> g =new  ArrayList<String>();
		g.add("SmokeTest");
		//test.setGroups(groups);
		List<XmlClass> classes = new ArrayList<XmlClass>();
		classes.add(new XmlClass(login));
		classes.add(new XmlClass(Search));
		
		test.setXmlClasses(classes) ;
		test.setIncludedGroups(g);
		
		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		suites.add(suite);
		TestNG tng = new TestNG();
		tng.setXmlSuites(suites);
		tng.run();
		
		/*TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng = new TestNG();
		testng.setTestClasses(new Class[] { Login_Scenario.class });
		testng.addListener(tla);
		testng.run();*/



	}


}
