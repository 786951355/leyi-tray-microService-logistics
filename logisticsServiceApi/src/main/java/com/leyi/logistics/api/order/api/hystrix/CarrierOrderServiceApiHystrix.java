/**
 * CarrierOrderServiceApiHystrix class
 *
 * @author Jerry Yang
 * @date 2018/7/4 18:40.
 */
package com.leyi.logistics.api.order.api.hystrix;

import com.leyi.logistics.api.order.api.CarrierOrderServiceApi;
import com.leyi.logistics.api.order.dto.CarrierOrderDetailDto;
import com.zhaoguanche.saas.core.base.Result;
import org.springframework.stereotype.Component;

@Component
public class CarrierOrderServiceApiHystrix implements CarrierOrderServiceApi {
    @Override
    public String carrierServiceSayHi(String carrierOrderCode) {
        return "链接超时，请稍后重试";
    }

    @Override
    public Result<Boolean> saveCarrierOrderDetail(String carrierOrderId) {
        return Result.timeout();
    }

    @Override
    public Result<CarrierOrderDetailDto> getCarrierOrderDetail(String carrierOrderId) {
        return Result.timeout();
    }
}
