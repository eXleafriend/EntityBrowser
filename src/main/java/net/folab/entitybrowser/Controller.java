package net.folab.entitybrowser;

import java.util.ArrayList;
import java.util.List;

/**
 * Controls models & views. This is responsible to C from MVC pattern. This
 * class is singleton.
 *
 * @author leafriend
 */
public final class Controller {

    /**
     * Instance of this class. This is a part of singleton pattern.
     */
    private static final Controller INSTANCE = new Controller();

    /**
     * Holds exception handlers which will be invoked when exception is thrown
     * in user-interface thread.
     */
    private transient final List<ExceptoinHandler> exceptoinHandlers = new ArrayList<ExceptoinHandler>();

    /**
     * Returns instance of this class. This is a part of singleton pattern.
     *
     * @return instance of this class. It's always same instance.
     */
    public static Controller getInstance() {
        return INSTANCE;
    }

    /**
     * Add exception handler. Added handler will be invoked when exception is
     * thrown in user-interface thread.
     *
     * @param handler
     *            to add
     */
    public void addExceptoinHandler(final ExceptoinHandler handler) {
        exceptoinHandlers.add(handler);
    }

    /**
     * Remove exception handler. Removed handler is not invoked when exception
     * is thrown in user-interface thread.
     *
     * @param handler
     *            to remove
     */
    public void removeExceptoinHandler(final ExceptoinHandler handler) {
        exceptoinHandlers.remove(handler);
    }

    /**
     * Remove all exception handler. Nothing is happened even an exception is
     * thrown in user-interface thread after clearing.
     */
    public void clearExceptoinHandler() {
        exceptoinHandlers.clear();
    }

    /**
     * Access modifier is set to <code>private</code> to restrict instantiation
     * from outside of class. This is a part of singleton pattern.
     */
    private Controller() {
        // DO NOTHING
    }

}
