package LazyInitializer.a2;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;


//@Component
@Named //similar to @Component
class BusinessService{
	DataService dataService;
//	@Autowired
	@Inject //similar to @Autowired
	public void setDataService(DataService dataService) {
		System.out.println("Setter Injection , This is print stmt");
		this.dataService = dataService;
	}

	public DataService getDataService() {
		return dataService;
	}
}
//@Component
@Named
class DataService{

}

@Configuration
@ComponentScan

public class CdiContextLauncherApplication{
	public static void main(String[] args) {
		try (var context =
					 new AnnotationConfigApplicationContext(CdiContextLauncherApplication.class)) {
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			System.out.println(context.getBean(BusinessService.class).getDataService());
		}
		}
	}
