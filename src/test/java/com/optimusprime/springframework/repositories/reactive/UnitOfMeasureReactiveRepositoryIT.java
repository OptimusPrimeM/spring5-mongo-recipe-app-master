package com.optimusprime.springframework.repositories.reactive;

import com.optimusprime.springframework.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataMongoTest
public class UnitOfMeasureReactiveRepositoryIT {

    public static final String EARTH = "Earth";
    @Autowired
    UnitOfMeasureReactiveRepository unitOfMeasureReactiveRepository;

    @Before
    public void setUp() throws Exception {
        unitOfMeasureReactiveRepository.deleteAll().block();
    }

    @Test
    public void testSaveUOM() throws Exception {
        UnitOfMeasure uom = new UnitOfMeasure();
        uom.setDescription(EARTH);


        unitOfMeasureReactiveRepository.save(uom).block();

        Long count =unitOfMeasureReactiveRepository.count().block();

        assertEquals(Long.valueOf(1L), count);
    }

    @Test
    public void testFindByDescription() throws Exception {
        UnitOfMeasure uom = new UnitOfMeasure();
        uom.setDescription(EARTH);

        unitOfMeasureReactiveRepository.save(uom).block();

        UnitOfMeasure fetchedUOM =  unitOfMeasureReactiveRepository.findByDescription(EARTH).block();

        assertEquals(EARTH, fetchedUOM.getDescription());
    }
}