package com.deliverytechy.delivery_api;

import com.deliverytechy.delivery_api.model.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OrderIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void createAndListOrders() {
        String url = "http://localhost:" + port + "/api/orders";

        Order toCreate = new Order("Alice", "Rua A, 123");
        ResponseEntity<Order> created = restTemplate.postForEntity(url, toCreate, Order.class);
        assertThat(created.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(created.getBody()).isNotNull();
        assertThat(created.getBody().getId()).isNotNull();

        Order[] list = restTemplate.getForObject(url, Order[].class);
        assertThat(list).isNotEmpty();
    }

}
