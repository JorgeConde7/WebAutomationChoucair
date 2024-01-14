package pe.choucair.step.producto;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="classpath:features/producto",glue = "pe.choucair.step.producto")
public class RunCucumberTest {

}
