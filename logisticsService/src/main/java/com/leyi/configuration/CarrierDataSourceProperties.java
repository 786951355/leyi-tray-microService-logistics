package com.leyi.configuration;

import com.zhaoguanche.saas.core.dataSource.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 读取yml配置的信息
 */
@ConfigurationProperties(
        prefix = "logisticsdatabase.mysql.admin"
)
public class CarrierDataSourceProperties extends DataSourceProperties {

}
