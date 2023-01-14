package com.example;

import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import io.quarkus.grpc.GrpcService;

@GrpcService
public class LegacyHelloGrpcService extends LegacyHelloGrpcGrpc.LegacyHelloGrpcImplBase {
  @Override
  public void legacySayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
    responseObserver.onError(new StatusRuntimeException(Status.INVALID_ARGUMENT));
  }
}
