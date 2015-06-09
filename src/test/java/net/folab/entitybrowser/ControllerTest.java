package net.folab.entitybrowser;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertThat;

import java.lang.reflect.Field;
import java.util.List;

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

    @Test
    public void testExceptionHandlers() throws Exception {

        // Prepare test

        Controller controller = Controller.getInstance();

        Field field = Controller.class.getDeclaredField("exceptoinHandlers");
        field.setAccessible(true);
        @SuppressWarnings("unchecked")
        List<ExceptoinHandler> exceptoinHandlers = (List<ExceptoinHandler>) field
                .get(controller);

        // Test initial state

        assertThat("exceptoinHandlers should not be null", exceptoinHandlers,
                is(not(nullValue())));

        assertThat("exceptoinHandlers should be empty at first",
                exceptoinHandlers.size(), is(0));

        // Test adding

        ExceptoinHandler handler = e -> {
        };

        controller.addExceptoinHandler(handler);

        assertThat("exceptoinHandlers should contain added handler",
                exceptoinHandlers, contains(handler));

        assertThat("exceptoinHandlers size should be 1",
                exceptoinHandlers.size(), is(1));

        // Test removing

        controller.removeExceptoinHandler(handler);

        assertThat("exceptoinHandlers should not contain added handler",
                exceptoinHandlers, not(contains(handler)));

        assertThat("exceptoinHandlers size should be 0",
                exceptoinHandlers.size(), is(0));

        // Test clearing

        controller.addExceptoinHandler(handler);

        controller.clearExceptoinHandler();

        assertThat("exceptoinHandlers size should be 0 after clear",
                exceptoinHandlers.size(), is(0));

        controller.clearExceptoinHandler();

        assertThat("exceptoinHandlers size should be 0 after clear again",
                exceptoinHandlers.size(), is(0));

    }

}
