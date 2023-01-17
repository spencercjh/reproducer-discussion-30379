package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.quarkus.grpc.GrpcClient;
import io.quarkus.test.junit.QuarkusTest;
import java.time.Duration;
import org.junit.jupiter.api.Test;

@QuarkusTest
class SmallryeHelloGrpcServiceTest {

  @SuppressWarnings("CdiInjectionPointsInspection")
  @GrpcClient
  HelloGrpc helloGrpc;

  @Test
  public void testHello() {
    final StatusRuntimeException exception =
        assertThrows(StatusRuntimeException.class, () -> helloGrpc
            .sayHello(HelloRequest.newBuilder().setName("Neo").build()).await()
            .atMost(Duration.ofSeconds(5)));
    assertEquals(Status.Code.INVALID_ARGUMENT, exception.getStatus().getCode());
  }

}
