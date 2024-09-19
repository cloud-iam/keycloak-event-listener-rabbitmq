package com.github.aznamier.keycloak.event.provider;

import dasniko.testcontainers.keycloak.KeycloakContainer;
import org.slf4j.Logger;

import java.io.File;
import java.nio.file.Files;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.slf4j.LoggerFactory.getLogger;

public abstract class AbstractIntegrationTest {


    public static final String IMAGE_NAME = "quay.io/keycloak/keycloak:25.0.4";

    private static final Logger LOGGER = getLogger(AbstractIntegrationTest.class);


    protected KeycloakContainer getKeycloakContainer(final Map<String, String> configuration) throws InterruptedException {
        LOGGER.info("starting container with image {}", IMAGE_NAME);

        final Map<String, String> configurationMap = new HashMap<>();
        configurationMap.putAll(configuration);

        final KeycloakContainer keycloak = new KeycloakContainer(IMAGE_NAME)
                .withEnv(configurationMap)
                .useTls()
                .withAdminUsername("admin")
                .withAdminPassword("password")
                .withContextPath(configurationMap.computeIfAbsent("KC_HTTP_RELATIVE_PATH", (key) -> "/"))
                .withProviderClassesFrom("target/classes")
                .withProviderLibsFrom(List.of(
                        new File(System.getProperty("user.home") + "/.m2/repository/com/rabbitmq/amqp-client/5.20.0/amqp-client-5.20.0.jar")
                ))
                .withEnabledMetrics()
                .withStartupTimeout(Duration.ofMinutes(2));

        keycloak.start();
        Thread.sleep(5_000);
        return keycloak;
    }

}
