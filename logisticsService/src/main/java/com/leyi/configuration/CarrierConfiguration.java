package com.leyi.configuration;

import com.zhaoguanche.saas.common.handler.GlobalExceptionHandler;
import com.zhaoguanche.saas.core.base.id.IdGenerate;
import com.zhaoguanche.saas.core.base.id.SnowflakeIDGenerate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarrierConfiguration {
    /**
     * 全局异常处理
     *
     * @return
     */
    @Bean
    public GlobalExceptionHandler getGlobalExceptionHandler() {
        return new GlobalExceptionHandler();
    }

    @Bean
    public IdGenerate getIdGenerate(@Value("${id-generator.machine-code:1}") Long machineCode) {
        return new SnowflakeIDGenerate(machineCode);
    }

}
