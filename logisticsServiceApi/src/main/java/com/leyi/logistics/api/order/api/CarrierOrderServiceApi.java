package com.leyi.logistics.api.order.api;

import com.leyi.logistics.api.order.dto.CarrierOrderDetailDto;
import com.leyi.logistics.api.order.api.hystrix.CarrierOrderServiceApiHystrix;
import com.zhaoguanche.saas.core.base.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "${spring.application.name:logistics-service}", fallback = CarrierOrderServiceApiHystrix.class)
public interface CarrierOrderServiceApi {
    @GetMapping(value = "/carrierOrder/carreirServiecSayHi")
    public String carrierServiceSayHi(@RequestParam String carrierOrderCode);

    @RequestMapping(value = "/carrierOrder/saveCarrierOrderDetail", method = RequestMethod.POST)
    public Result<Boolean> saveCarrierOrderDetail(@RequestParam String carrierOrderId);

    @GetMapping(value = "/carrierOrder/getCarrierOrderDetail")
    public Result<CarrierOrderDetailDto> getCarrierOrderDetail(@RequestParam String carrierOrderCode);
}
