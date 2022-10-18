package com.wj.clients.owner;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "owner",
        url = "${clients.owner.url}"
)
public interface OwnerClient {

    @GetMapping(path = "/api/owner/{licensePlate}")
    public OwnerCheckResponse checkOwner(@PathVariable("licensePlate") Integer licensePlate);
}
