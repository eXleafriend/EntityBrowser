package net.folab.entitybrowser;

/**
 * Used when an exception is thrown in user-interface thread.
 *
 * @author leafriend
 */
@FunctionalInterface
public interface ExceptoinHandler {

    /**
     * Invoked when an exception is thrown in user-interface thread.
     *
     * @param exception
     *            thrown in user-interface thread
     */
    void handleException(Exception exception);

}
