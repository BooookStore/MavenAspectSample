import com.mycompany.app.*;

aspect Logger {

	pointcut helloAspect() : call(void App.HelloAspect());

	after(): helloAspect() {
		System.out.println("WORLD");
	}

}
