/**
 * CarrierOrderMapper class
 *
 * @author Jerry Yang
 * @date 2018/7/5 13:28.
 */
package com.leyi.logistics.mapper;

import com.leyi.logistics.entity.order.module.CarrierOrderModule;
import com.leyi.logistics.entity.order.po.CarrierOrder;
import com.zhaoguanche.saas.core.base.dao.BaseDao;
import org.apache.ibatis.annotations.Param;

public interface CarrierOrderMapper extends BaseDao<Long, CarrierOrder> {
    CarrierOrderModule getCarrierOrderBy(@Param("carrierOrderCode") String carrierOrderCode);
}