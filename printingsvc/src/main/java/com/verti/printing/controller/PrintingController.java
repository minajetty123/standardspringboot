package com.verti.printing.controller;

import com.verti.printing.service.PrintingService;
import com.verti.printing.service.MTextApiService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
@Tag(name = "Printing API", description = "API for printing services and external API integration")
public class PrintingController {

    private final PrintingService printingService;
    private final MTextApiService mTextApiService;

    public PrintingController(PrintingService printingService, MTextApiService mTextApiService) {
        this.printingService = printingService;
        this.mTextApiService = mTextApiService;
    }

    @Operation(
            summary = "Health Check",
            description = "Returns the health status of the application",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Service is running"),
                    @ApiResponse(responseCode = "500", description = "Service is unavailable")
            }
    )
    @GetMapping("/healthz")
    public String healthCheck() {
        return printingService.healthCheck();
    }

    @Operation(
            summary = "Fetch External Data",
            description = "Calls an external REST API and returns its response",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successful response"),
                    @ApiResponse(responseCode = "500", description = "External service error")
            }
    )
    @GetMapping("/external")
    public Mono<String> fetchExternalData() {
        return mTextApiService.checkMTextStatus()
                .onErrorReturn("Fallback response due to error");
    }
}
