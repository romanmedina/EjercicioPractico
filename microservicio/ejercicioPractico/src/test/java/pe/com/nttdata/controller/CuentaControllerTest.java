package pe.com.nttdata.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CuentaControllerTest {

	 @Autowired
	 private WebTestClient webTestClient;
	 
	    @Test
	    void getAll() {
	        this.webTestClient
	                .get()
	                .uri("/api/v1/cuentas")
	                .exchange()
	                .expectStatus()
	                .is2xxSuccessful()
	                .expectHeader()
	                .contentType(MediaType.APPLICATION_JSON)
	                .expectBody()
	                .jsonPath("$.length()").isEqualTo(5);
	    }
}
