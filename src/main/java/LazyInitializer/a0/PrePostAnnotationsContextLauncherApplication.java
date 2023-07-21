package LazyInitializer.a0;
//Very important in spring concept-> @PostContruct and @PreDestroy
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class SomeClass{
private  someDependency someDependency;
public SomeClass(LazyInitializer.a0.someDependency someDependency) {
		super();
		this.someDependency = someDependency;
		System.out.println("All dependencies are ready");
	}
	@PostConstruct
	public void initialize(){
		someDependency.getReady();
		}
		@PreDestroy
	public void Cleanup(){
			System.out.println("CleanedUp!!");
		}
	}

@Component
class someDependency{

	public void getReady() {
		System.out.println("some logic using dependency");
	}

}

//Exploring PostConstruct and PreDestroy
@Configuration
@ComponentScan
public class PrePostAnnotationsContextLauncherApplication{
	public static void main(String[] args) {
		try (var context =
					 new AnnotationConfigApplicationContext(PrePostAnnotationsContextLauncherApplication.class)) {
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		}
		}
	}
