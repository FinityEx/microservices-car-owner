package com.wj.owner;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OwnerService {

    private final OwnerRepository ownerRepository;

    public boolean  checkOwner(Integer licensePlate) {
        if(ownerRepository.findByLicensePlate(licensePlate).isPresent())
            return true;
        else return false;
    }

    public void registerOwner(@NotNull OwnerForm form){
        if(checkOwner(form.licensePlate()))
            throw new IllegalStateException("This car already has an owner!");
        else {
            Owner owner = Owner.builder()
                    .licensePlate(form.licensePlate())
                    .name(form.name())
                    .build();

            ownerRepository.saveAndFlush(owner);
        }
    }
}
