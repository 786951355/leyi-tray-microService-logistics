/**
 * CarrierOrderServiceImpl class
 *
 * @author Jerry Yang
 * @date 2018/7/5 13:52.
 */
package com.leyi.logistics.serviceRepository.order;


import com.leyi.logistics.base.CarrierExceptionCode;
import com.leyi.logistics.entity.order.module.CarrierOrderModule;
import com.leyi.logistics.entity.order.po.CarrierOrder;
import com.leyi.logistics.mapper.CarrierOrderMapper;
import com.zhaoguanche.saas.common.context.BaseContextHandler;
import com.zhaoguanche.saas.core.exception.BizException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarrierOrderServiceBiz {
    @Autowired
    private CarrierOrderMapper carrierOrderMapper;

    public void saveCarrierOrder(Long carrierOrderId){
        CarrierOrder carrierOrder = carrierOrderMapper.selectByPrimaryKey(carrierOrderId);
        if(null == carrierOrder){
            throw new BizException(CarrierExceptionCode.MISS_CARRIER_ORDER.getCode(), CarrierExceptionCode.MISS_CARRIER_ORDER.getMsg());
        }

        CarrierOrder uptCarrierOrder = new CarrierOrder();
        uptCarrierOrder.setId(carrierOrderId);
        uptCarrierOrder.setUpdatedBy(BaseContextHandler.getUserName());
        carrierOrderMapper.updateByPrimaryKeySelective(uptCarrierOrder);


        /*if(1==1){
            throw new BizException(2002, "测试数据库事务回滚异常");
        }

        CarrierOrder _uptCarrierOrder = new CarrierOrder();
        _uptCarrierOrder.setId(2L);
        _uptCarrierOrder.setUpdatedBy("JerryYang_admin");
        carrierOrderMapper.updateByPrimaryKeySelective(_uptCarrierOrder);*/
    }

    public CarrierOrderModule getCarrierOrder(String carrierOrderCode) {
        return carrierOrderMapper.getCarrierOrderBy(carrierOrderCode);
    }
}
