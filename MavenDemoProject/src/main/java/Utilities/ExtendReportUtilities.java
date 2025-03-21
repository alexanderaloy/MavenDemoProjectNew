package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportUtilities {
	public static final ExtentReports extentReports = new ExtentReports(); //object globally declared

	public synchronized static ExtentReports createExtentReports() {
		ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html"); // path of report to be generated
		// './' represents current project directory
		// extend-reports -> folder generation for reports
		//extent-report.html -> generated extend report
		reporter.config().setReportName("7RMart  Project"); // config().setReportName("7RMart  Project") -> provided by ExtentSparkReporter class
		//extent-report.html title name " 7RMart  Project " -> command for providing title of the report
		extentReports.attachReporter(reporter);//connecting both classes object for generation of reports
		extentReports.setSystemInfo("Organization", "Obsqura"); //report details to be shown at end
		extentReports.setSystemInfo("Name", "Alex"); //report details to be shown at end
		return extentReports; //method returning reports 
	}
}

//detailed emailable report html report  //detailed report of test analysis
//first add dependency aventstack for extend report -> ExtentSparkReporter and extentReports classes provided by depenency 
//created a package in src test java "generateReports" -> create a class Listeners -> add code