package com.wj.car;

import com.wj.clients.owner.OwnerClient;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    private final OwnerClient ownerClient;

    public void registerCar(@NotNull CarRegistrationForm form){
        if(ownerClient.checkOwner(form.licensePlate()).hasOwner())
            throw new IllegalStateException("This car already has an owner!");
        else {
            Car car = Car.builder()
                    .brand(form.brand())
                    .model(form.model())
                    .licensePlate(form.licensePlate())
                    .build();

            carRepository.saveAndFlush(car);
        }
    }
}
