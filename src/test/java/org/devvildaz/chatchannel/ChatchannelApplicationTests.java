package org.devvildaz.chatchannel;

import org.devvildaz.chatchannel.config.AppSecurity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;


@WebFluxTest
@WithMockUser
@ExtendWith(SpringExtension.class)
class ChatchannelApplicationTests {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private WebTestClient webClient;

	@Test
	void someTest() {
		webClient.get()
				.uri("/user")
				.exchange().expectStatus().isOk().expectBody().consumeWith(System.out::println);
	}
}
