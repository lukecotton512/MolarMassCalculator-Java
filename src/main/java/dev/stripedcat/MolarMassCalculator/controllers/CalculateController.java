package dev.stripedcat.MolarMassCalculator.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculateController {
    @GetMapping("/calculate/{formula}")
    public String calculate(@PathVariable("formula") String formula) {
        return formula;
    }
}
