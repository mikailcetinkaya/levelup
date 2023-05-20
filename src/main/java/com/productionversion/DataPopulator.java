package com.productionversion;

import io.micronaut.context.annotation.Requires;
import io.micronaut.context.event.StartupEvent;
import io.micronaut.runtime.event.annotation.EventListener;
import jakarta.inject.Singleton;

import javax.transaction.Transactional;

import java.util.List;

import static io.micronaut.context.env.Environment.TEST;

@Singleton
@Requires(notEnv=TEST)
public class DataPopulator {

    private final ThingRepository tr;

    public DataPopulator(ThingRepository tr) {
        this.tr=tr;
    }

    @EventListener
    @Transactional
    void init(StartupEvent startupEvent) {
        if (tr.count() == 0) {

            tr.saveAll(List.of(new Thing("SSS",4)));
        }
    }
}