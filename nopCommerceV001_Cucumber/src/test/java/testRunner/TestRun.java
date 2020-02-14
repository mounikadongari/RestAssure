package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//for testrunner class before class we should define @RunWith
@RunWith(Cucumber.class)
@CucumberOptions
(         //features folder--->login.features(path)
		features=".\\Features\\Customer.feature",//features=".//Features/"
		//features={".\\Features\\Customer.feature",".\\Features\\Login.feature"}'
		    //stepdefinations (foldername)
		glue ="stepDefinations",
		//it will crosscheck weather the corresponding feature file is having corresonding stepdefination or not 
		//featurefile=stepdefination
		dryRun = false,//(first Keep it true=to cross chek and run the output once after that cross check keep it false to execute  )
		monochrome = true,//remove unnecessary characters in console window
		plugin = {"pretty","html:test-output"},//it gives output in console very clearly
		tags = {"@sanity","@regression"}//sanith AND regression executed
		//tags= {"@santity,@regression"}//sanity OR regression
		)



public class TestRun {

}
