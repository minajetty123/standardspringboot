package com.verti.printing.controller;

import com.verti.printing.service.PrintingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Tag(name = "Printing API", description = "API for printing services")
public class PrintingController {

    private final PrintingService printingService;

    public PrintingController(PrintingService svc) {
        this.printingService = svc;
    }

    @Operation(summary = "Health Check", description = "Returns the health status of the application")
    @GetMapping("/healthz")
    public String healthCheck() {
        return printingService.healthCheck();
    }
}
