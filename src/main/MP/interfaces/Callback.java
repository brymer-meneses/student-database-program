package MP.interfaces;

/**
 * An interface that is used to enable a function to receive a lambda function.
 * This is needed to simplify the process of setting the behavior of each button among the
 * various GUI components.
 *
 * This solution was taken from here: https://stackoverflow.com/a/53377897
 */
public interface Callback {
    void call();
}
