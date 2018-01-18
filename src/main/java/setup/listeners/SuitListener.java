package setup.listeners;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static setup.DriverSetup.getDriver;

public class SuitListener extends TestListenerAdapter {
    private static Logger Log = Logger.getLogger(SuitListener.class.getName());

    @Override
    public void onTestFailure(ITestResult currentTest) {
        Log.info("Taking a screenshot");
        File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss")
                .format(Calendar.getInstance().getTime());
        File screenShotName = new File("./target/screenshots/" +
                currentTest.getName() + timeStamp + ".png");

        try{
            FileUtils.copyFile(srcFile, screenShotName);
        }catch (IOException e) {
            e.printStackTrace();
        }
        Log.info("********************************************");
        Log.info("Failed ----> " + currentTest.getName());
        Log.info("********************************************");
    }
}
