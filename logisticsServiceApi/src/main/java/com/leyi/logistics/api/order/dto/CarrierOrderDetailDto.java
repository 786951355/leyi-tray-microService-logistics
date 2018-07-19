/**
 * CarrierOrderDetailDto class
 *
 * @author Jerry Yang
 * @date 2018/7/4 18:33.
 */
package com.leyi.logistics.api.order.dto;

import java.io.Serializable;

public class CarrierOrderDetailDto implements Serializable {
    private Long id;
    private String carrierOrderCode;

    private String warehouseName;
    private String warehouseAddress;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarrierOrderCode() {
        return carrierOrderCode;
    }

    public void setCarrierOrderCode(String carrierOrderCode) {
        this.carrierOrderCode = carrierOrderCode;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getWarehouseAddress() {
        return warehouseAddress;
    }

    public void setWarehouseAddress(String warehouseAddress) {
        this.warehouseAddress = warehouseAddress;
    }
}
