package com.verti.printing.service;

import org.springframework.stereotype.Service;

@Service
public class PrintingService {
    public String healthCheck() {
        return "Healthz";
    }
}
