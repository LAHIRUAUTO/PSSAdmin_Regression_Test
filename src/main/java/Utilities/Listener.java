package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;


public class Listener extends GenericUtils implements ITestListener {
    ExtentTest test;

    static ExtentReports extent = ExtentReporter.getReportObj ();

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test Passed");
        String filePath = null;
        try {
            filePath = getScreenshot(result.getMethod().getMethodName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName() );


        System.out.println("Test Case - " + result.getMethod().getMethodName() + " : SUCCESS");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, "Test Faied");
        test.fail(result.getThrowable());
        String filePath = null;
        try {
            filePath = getScreenshot(result.getMethod().getMethodName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName() );

        System.out.println("Test Case - " + result.getMethod().getMethodName() + " : FAILED");

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, "Test Skipped");
        test.skip(result.getThrowable());

        System.out.println("Test Case - " + result.getMethod().getMethodName() + " : SKIPPED");


    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }

}
