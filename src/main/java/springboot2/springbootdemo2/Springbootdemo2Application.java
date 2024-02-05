package springboot2.springbootdemo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import springboot2.springbootdemo2.service.FileStorageService;

@SpringBootApplication
@RestController
public class Springbootdemo2Application implements CommandLineRunner {

//	@RequestMapping(value = "/" )
//	public String index()
//	{
//		return "<h1 >Hello this is Main page</h1>";
//	}
	@Autowired
	private FileStorageService fireStorageService;
	public static void main(String[] args) {
		SpringApplication.run(Springbootdemo2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		fireStorageService.init();
	}
}
