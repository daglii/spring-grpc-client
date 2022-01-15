package com.dagli.grpcclient.grpc;

import com.dagli.HelloRequest;
import com.dagli.HelloServiceGrpc.HelloServiceBlockingStub;
import lombok.Setter;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Component;

/**
 * Configuration of SpringGrpcServerClient
 */
@Component
@Setter
public class SpringGrpcServerClient {

  @GrpcClient("springgrpcserver")
  private HelloServiceBlockingStub helloServiceBlockingStub;

  /**
   * Method calling hello method from SpringGrpcServer service.
   */
  public String hello(String name) {
    return helloServiceBlockingStub.hello(HelloRequest.newBuilder().setName(name).build())
        .getMessage();
  }

}
