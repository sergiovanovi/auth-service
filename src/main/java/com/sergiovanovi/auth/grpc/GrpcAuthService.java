package com.sergiovanovi.auth.grpc;

import com.sergiovanovi.auth.AuthRequest;
import com.sergiovanovi.auth.AuthResponse;
import com.sergiovanovi.auth.AuthServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GrpcAuthService extends AuthServiceGrpc.AuthServiceImplBase {
    @Override
    public void authorize(AuthRequest request, StreamObserver<AuthResponse> responseObserver) {
        request.getLogin();
        request.getPassword();
        request.getToken();
        AuthResponse authResponse = AuthResponse.newBuilder().setToken("123").build();
        responseObserver.onNext(authResponse);
        responseObserver.onCompleted();
    }
}
