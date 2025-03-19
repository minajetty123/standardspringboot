package com.verti.printing.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class MTextApiService {
    private final WebClient webClient;

    public MTextApiService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.example.com").build();
    }

    public Mono<String> checkMTextStatus() {
        return webClient.get()
                .uri("/external-data")
                .retrieve()
                .bodyToMono(String.class);
    }
}