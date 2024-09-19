package com.github.aznamier.keycloak.event.provider;

import org.junit.jupiter.api.Test;

import java.util.Map;

public class EssentialsIntegrationTest extends AbstractIntegrationTest {

    @Test
    public void should_start() throws InterruptedException {
        getKeycloakContainer(Map.of());
    }
}
