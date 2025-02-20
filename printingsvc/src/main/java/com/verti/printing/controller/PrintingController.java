package com.verti.printing.controller;

import com.verti.printing.service.PrintingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PrintingController {

    private final PrintingService printingService;

    public PrintingController(PrintingService svc) {
        this.printingService = svc;
    }

    @GetMapping("/healthz")
    public String sayHello() {
        return printingService.healthCheck();
    }
}
