package com.dagli.grpcclient.controller;

import com.dagli.grpcclient.grpc.SpringGrpcServerClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for testing gRPC communication.
 */
@RestController
@RequestMapping("/api/v1/grpc/test")
@RequiredArgsConstructor
public class HelloController {

  private final SpringGrpcServerClient springGrpcServerClient;

  @GetMapping("/hello")
  public String hello(@RequestParam("name") String name) {
    return springGrpcServerClient.hello(name);
  }

}
