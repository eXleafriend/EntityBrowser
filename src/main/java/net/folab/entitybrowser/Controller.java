package net.folab.entitybrowser;

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
     * Returns instance of this class. This is a part of singleton pattern.
     *
     * @return instance of this class. It's always same instance.
     */
    public static Controller getInstance() {
        return INSTANCE;
    }

    /**
     * Access modifier is set to <code>private</code> to restrict instantiation
     * from outside of class. This is a part of singleton pattern.
     */
    private Controller() {
        // DO NOTHING
    }

}
