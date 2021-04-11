package Report;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import net.masterthought.cucumber.json.support.Status;
import net.masterthought.cucumber.presentation.PresentationMode;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Reportutility {

    public static void generateJVMReport(){

        File reportOutputDirectory = new File("reports");
        List<String> jsonFiles = new ArrayList<String>();
        jsonFiles.add("target/cucumber.json");

        String buildNumber = "1";
        String projectName = "OrangeHRM";

        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
        configuration.addPresentationModes(PresentationMode.RUN_WITH_JENKINS);
        configuration.setNotFailingStatuses(Collections.singleton(Status.SKIPPED));
        
        configuration.setBuildNumber(buildNumber);
        configuration.addClassifications("Platform", "Windows 10");
        configuration.addClassifications("BrowserName", "Chrome");
        configuration.addClassifications("Environment", "release/1.0");

        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        Reportable result = reportBuilder.generateReports();

    }
}