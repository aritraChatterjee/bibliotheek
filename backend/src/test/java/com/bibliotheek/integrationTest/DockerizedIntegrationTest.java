package com.bibliotheek.integrationTest;

import org.junit.ClassRule;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.DockerComposeContainer;
import org.testcontainers.containers.wait.strategy.Wait;

import java.io.File;

class DockerizedIntegrationTest {
    @ClassRule
    public static DockerComposeContainer compose =
            new DockerComposeContainer(
                    new File("src/test/docker/test-docker-compose.yml"))
                    .withExposedService("bibliotheek-backend", 9001, Wait.forListeningPort())
                    .withExposedService("postgres",25432)
                    .withLocalCompose(true);

    @Test
    void givenSimpleWebServerContainer_whenGetReuqest_thenReturnsResponse()
            throws Exception {
        String address = "http://" + compose.getServiceHost("bibliotheek-backend", 9001)
                + ":" + compose.getServicePort("bibliotheek-backend", 9001);

        System.out.println("here");

    }
}
