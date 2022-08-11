package TesteQA.TesteQA;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
			tags = "@test03",                                     // tag do cenário a ser executado
			features = "src/test/resources/features/",           // local de onde o cenario sera executado
			glue = "steps",
			plugin = {
					"pretty",
					"html:target/Relatorio-html.html"
			})

public class AppTest {

}


