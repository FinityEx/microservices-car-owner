package com.wj.owner;

import com.wj.clients.owner.OwnerCheckResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/owner")
@RestController
@AllArgsConstructor
@Slf4j
public class OwnerController {

    private final OwnerService ownerService;

    @GetMapping(path = "/{licensePlate}")
    public OwnerCheckResponse hasOwner(@PathVariable("licensePlate") Integer licensePlate){
        log.info("Owner check request for license plate: {}", licensePlate);
        boolean carOwner = ownerService.checkOwner(licensePlate);

        return new OwnerCheckResponse(carOwner);
    }

    @PostMapping(path = "/register")
    public void register(@RequestBody OwnerForm ownerForm){
        ownerService.registerOwner(ownerForm);
        log.info("Successfully registered new owner for license plate: {}",
                ownerForm.licensePlate());
    }
}
