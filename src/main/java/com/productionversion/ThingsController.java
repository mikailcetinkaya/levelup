package com.productionversion;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;

import javax.validation.constraints.Positive;
import java.util.Optional;

@Controller("/things")
@ExecuteOn(TaskExecutors.IO)
public class ThingsController {
    private final ThingRepository thingRepository;

    public ThingsController(ThingRepository thingRepository) {
        this.thingRepository = thingRepository;
    }

    @Get("/{id}")
    Optional<Thing> get(long id){
        return thingRepository.findById(id);
    }

    @Get("/all")
    Iterable<Thing> getAll(){
        return thingRepository.findAll();
    }
    @Post("/create/{name}/{amount}")
    HttpResponse<Thing> create(String name, @Positive int amount){
        return HttpResponse.created(thingRepository.save(new Thing(name,amount)));
    }

}
