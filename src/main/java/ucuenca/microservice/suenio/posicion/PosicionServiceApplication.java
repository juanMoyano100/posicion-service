package ucuenca.microservice.suenio.posicion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PosicionServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(PosicionServiceApplication.class, args);
	}

}
