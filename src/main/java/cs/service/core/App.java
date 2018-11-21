package cs.service.core;

import cs.service.core.filter.LoggingFilter;
import cs.service.core.listeners.StartListeners;
import vn.cs123.lib.system.SystemAPI;
import vn.cs123.lib.utils.common.Log123CS;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws Exception {
        try {
            SystemAPI.startServer("cs.service.core.resources", StartListeners.class, LoggingFilter.class, null);
        } catch (RuntimeException ex) {
            Log123CS.writeError(ex);
        }
    }
}
