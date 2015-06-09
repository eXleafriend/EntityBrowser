package net.folab.entitybrowser;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ControllerTest {

    @Test
    public void testGetInstance() {

        Controller first = Controller.getInstance();
        assertThat("getInstance() should return non-null value", first,
                is(not(nullValue())));

        Controller second = Controller.getInstance();
        assertThat("getInstance() should return exactly same intance always",
                second, is(sameInstance(first)));

    }

}
