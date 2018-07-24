package com.optimusprime.springframework.services;

import com.optimusprime.springframework.commands.UnitOfMeasureCommand;
import reactor.core.publisher.Flux;

/**
 * Created by jt on 6/28/17.
 */
public interface UnitOfMeasureService {

//    Set<UnitOfMeasureCommand> listAllUoms();
    Flux<UnitOfMeasureCommand> listAllUoms();
}
