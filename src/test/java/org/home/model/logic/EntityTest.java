package org.home.model.logic;

import org.home.model.entity.Record;
import org.junit.Test;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class EntityTest {

    @Test
    public void RecordsDeleteTest() {

        List<Record> rec = new ArrayList<>();

        Record r1 = new Record();
        r1.setId(1);
        r1.setDescription("description1");
        r1.setValue(1);
        r1.setDate(new GregorianCalendar(2017, 1, 1));
        rec.add(r1);

        Record r2 = new Record();
        r2.setId(2);
        r2.setDescription("description2");
        r2.setValue(2);
        r2.setDate(new GregorianCalendar(2017, 2, 2));
        rec.add(r2);

        rec.remove(r1);

        assertTrue(rec.size() == 1);
    }

}
