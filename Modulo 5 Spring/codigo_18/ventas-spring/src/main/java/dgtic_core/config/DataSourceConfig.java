package dgtic_core.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .driverClassName("com.mysql.cj.jdbc.Driver") // Clase del driver
                .url("jdbc:mysql://localhost:3306/ventas?useSSL=false&serverTimezone=UTC")
                .username("root")
                .password("56457977Ac*")
                .build();
    }


}
