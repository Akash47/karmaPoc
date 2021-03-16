package io.vertx.examples.webapiservice;

import io.vertx.core.Vertx;
import io.vertx.junit5.VertxExtension;
import io.vertx.junit5.VertxTestContext;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(VertxExtension.class)
class WebApiServiceExampleMainVerticleTest {

    Vertx currentVertx;
    VertxTestContext previousTestContext;

    @BeforeEach
    void prepare(Vertx vertx, VertxTestContext testContext) {
        assertThat(testContext).isNotSameAs(previousTestContext);
        previousTestContext = testContext;
        assertThat(currentVertx).isNotSameAs(vertx);
        currentVertx = vertx;
        vertx.deployVerticle(new WebApiServiceExampleMainVerticle(), testContext.succeeding(id -> testContext.completeNow()));
    }

    @RepeatedTest(2)
    @DisplayName("Test the validity of references and scoping")
    void checkDeployments(Vertx vertx, VertxTestContext testContext) {
        assertThat(testContext).isNotSameAs(previousTestContext);
        previousTestContext = testContext;
        assertThat(vertx).isSameAs(currentVertx);
        assertThat(vertx.deploymentIDs()).isNotEmpty().hasSize(1);
        testContext.completeNow();
    }

    @AfterEach
    void cleanup(Vertx vertx, VertxTestContext testContext) {
        assertThat(testContext).isNotSameAs(previousTestContext);
        previousTestContext = testContext;
        assertThat(vertx.deploymentIDs()).isNotEmpty().hasSize(1);
        vertx.close(testContext.succeeding(v -> testContext.completeNow()));
    }
}