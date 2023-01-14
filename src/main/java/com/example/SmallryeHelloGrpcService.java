package com.example;

import io.quarkus.grpc.GrpcService;
import io.smallrye.mutiny.Uni;

/**
 * @author spencercjh
 */
@GrpcService
public class SmallryeHelloGrpcService implements HelloGrpc {


  @Override
  public Uni<HelloReply> sayHello(HelloRequest request) {
    throw new IllegalArgumentException("test");
  }

}
