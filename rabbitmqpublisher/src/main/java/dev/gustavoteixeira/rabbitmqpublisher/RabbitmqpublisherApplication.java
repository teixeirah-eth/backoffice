package dev.gustavoteixeira.rabbitmqpublisher;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitmqpublisherApplication implements CommandLineRunner {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqpublisherApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		rabbitTemplate.convertAndSend("Hello again!!");
		System.out.println("args = " + args);
		Registro registro = Registro.builder().description("Simple description").origin("RABBITMQ PUBLISHER APP").build();
		rabbitTemplate.convertAndSend("TestExchange", "testRouting", gson.toJson(registro));
	}
}
