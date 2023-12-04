package dev.minitrello.application;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        glue = "dev.minitrello.application.service"
)
public class AcceptanceTestSuite {
}
