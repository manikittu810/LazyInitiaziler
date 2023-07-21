package LazyInitializer.LazyInitializer;

import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;

@Component
class ClassA{

}
@Component
@Lazy(value = false)
class ClassB{
	private  ClassA classA; //Dependency

	public ClassB(ClassA classA){
		System.out.println("Logic goes here");
		this.classA =classA;
	}

	public void doSomething() {
		System.out.println("do some  thing");
	}
}
@Configuration
@ComponentScan
public class LazyInitializerApplication {
	public static void main(String[] args) {
		try (var context =
					 new AnnotationConfigApplicationContext(LazyInitializerApplication.class)) {
			System.out.println("Initialization of conetext is completed ");
			context.getBean(ClassB.class).doSomething();

		}
	}

}
