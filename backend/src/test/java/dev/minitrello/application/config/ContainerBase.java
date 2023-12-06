package dev.minitrello.application.config;


import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;

import org.testcontainers.lifecycle.Startables;


@ActiveProfiles("test")
public abstract class ContainerBase {
    public static final PostgreSQLContainer<?> container;

    static {
        container =  new PostgreSQLContainer<>("postgres:11.1")
                .withDatabaseName("integration-tests-db")
                .withUsername("sa")
                .withPassword("sa");
    }

    static {
        Startables.deepStart(container).join();
    }


    @DynamicPropertySource
    public static void properties(DynamicPropertyRegistry registry) {

        registry.add("spring.datasource.url", container::getJdbcUrl);
        registry.add("spring.datasource.username", container::getUsername);
        registry.add("spring.datasource.password", container::getPassword);
    }
}
