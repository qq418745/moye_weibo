package top.moyeye.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * 配置类 数据源配置
 */
@Configuration
public class DataSourceConfig {
    @Primary
    @Bean()
    public DataSource dataSource(){
        return DruidDataSourceBuilder.create().build();
    }
}
