package com.wj.car;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("api/register")
public class CarController {

    private final CarService carService;

    @PostMapping
    public void register(@RequestBody CarRegistrationForm form){
        carService.registerCar(form);
        log.info("Registered car with license plate: {}", form.licensePlate());
    }
}
