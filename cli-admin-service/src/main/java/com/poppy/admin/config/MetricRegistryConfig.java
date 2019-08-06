package com.poppy.admin.config;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: DENGHUANQING1
 * @create: 2019-08-06 11:39
 **/
@Configuration
public class MetricRegistryConfig {
    @Bean
    public MetricRegistry metrics() {
        return new MetricRegistry();
    }

    @Bean
    public ConsoleReporter consoleReporter(MetricRegistry metrics) {
        return ConsoleReporter.forRegistry(metrics)
                .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS)
                .build();
    }

    @Bean
    public Meter requestMeter(MetricRegistry metrics) {
        return metrics.meter("coupon_pkg");
    }
}
