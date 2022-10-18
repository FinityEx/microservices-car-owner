package com.wj.car;

import com.wj.clients.confirmation.ConfirmationCheckResponse;
import com.wj.clients.owner.OwnerClient;
import com.wj.messageqs.RabbitProducer;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    private final OwnerClient ownerClient;

    private final RabbitProducer rabbitProducer;

    public void registerCar(@NotNull CarRegistrationForm form){
        if(ownerClient.checkOwner(form.licensePlate()).hasOwner())
            throw new IllegalStateException("This car already has an owner!");
        else {
            Car car = Car.builder()
                    .brand(form.brand())
                    .model(form.model())
                    .licensePlate(form.licensePlate())
                    .build();

            //save the car built and send an async confirmation
            carRepository.saveAndFlush(car);
            rabbitProducer.publish(new ConfirmationCheckResponse(true),
                    "exchange",
                    "confirmation.routing-key");
        }
    }
}
