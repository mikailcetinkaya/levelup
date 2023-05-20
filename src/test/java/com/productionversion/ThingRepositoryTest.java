package com.productionversion;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
@MicronautTest
class ThingRepositoryTest {

    @Inject
    ThingRepository tr;
    @Test
    void findByName() {
        tr.save(new Thing("sss",43));
        assertEquals("sss",tr.findByName("sss").get().name());

    }
}