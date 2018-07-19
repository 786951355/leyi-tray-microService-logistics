/**
 * CarrierOrderServiceApiImpl class
 *
 * @author Jerry Yang
 * @date 2018/7/4 18:58.
 */
package com.leyi.logistics.serviceApiImpl.order;

import com.example.auth.service.client.annotation.IgnoreAppToken;
import com.leyi.logistics.api.order.api.CarrierOrderServiceApi;
import com.leyi.logistics.api.order.dto.CarrierOrderDetailDto;

import com.leyi.logistics.base.CarrierExceptionCode;
import com.leyi.logistics.serviceRepository.order.CarrierOrderServiceBiz;
import com.leyi.logistics.entity.order.module.CarrierOrderModule;
import com.zhaoguanche.saas.core.base.Result;
import com.zhaoguanche.tools.mapper.utils.MapperUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.zhaoguanche.saas.core.utils.BizAssert.assertNotNull;

@Api(value = "API - CarrierOrderServiceApiImpl", description = "承运商运单管理")
@RestController
@Slf4j
public class CarrierOrderServiceApiImpl implements CarrierOrderServiceApi {
    @Autowired
    private CarrierOrderServiceBiz carrierOrderServiceBiz;

    @Override
    @IgnoreAppToken
    @GetMapping(value = "/carrierOrder/carreirServiecSayHi")
    public String carrierServiceSayHi(@RequestParam String carrierOrderCode){
        log.info("Slf4j logger annotation test....");
        return "carrier serviceRepository message : " + carrierOrderCode;
    }

    @Override
    @RequestMapping(value = "/carrierOrder/saveCarrierOrderDetail", method = RequestMethod.POST)
    @ApiOperation(value = "修改运单详情", notes = "Response Messages 中的HTTP Status Code 值的是errcode的值")
    public Result<Boolean> saveCarrierOrderDetail(@RequestParam String carrierOrderId) {

        assertNotNull(CarrierExceptionCode.MISS_CARRIER_ORDER_CODE, carrierOrderId);

        carrierOrderServiceBiz.saveCarrierOrder(Long.valueOf(carrierOrderId));

        return Result.success(true);
    }

    @Override
    @GetMapping(value = "/carrierOrder/getCarrierOrderDetail")
    @ApiOperation(value = "获取运单详情", notes = "Response Messages 中的HTTP Status Code 值的是errcode的值")
    public Result<CarrierOrderDetailDto> getCarrierOrderDetail(@RequestParam String carrierOrderCode) {
        CarrierOrderDetailDto data = null;
        CarrierOrderModule carrierOrder = null;
        Result<CarrierOrderDetailDto> success = null;

        carrierOrder = carrierOrderServiceBiz.getCarrierOrder(carrierOrderCode);
        CarrierOrderDetailDto carrierOrderDetailDto = MapperUtils.mapper(carrierOrder, CarrierOrderDetailDto.class);

        return Result.success(carrierOrderDetailDto);
    }
}
