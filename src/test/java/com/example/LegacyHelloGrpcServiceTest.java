package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.quarkus.grpc.GrpcClient;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

@QuarkusTest
class LegacyHelloGrpcServiceTest {
  @SuppressWarnings("CdiInjectionPointsInspection")
  @GrpcClient
  LegacyHelloGrpcGrpc.LegacyHelloGrpcBlockingStub stub;

  @SuppressWarnings("ResultOfMethodCallIgnored")
  @Test
  void legacySayHello() {
    final StatusRuntimeException exception =
        assertThrows(StatusRuntimeException.class,
            () -> stub.legacySayHello(HelloRequest.newBuilder().setName("Neo").build()));
    assertEquals(Status.Code.INVALID_ARGUMENT, exception.getStatus().getCode());
  }
}
