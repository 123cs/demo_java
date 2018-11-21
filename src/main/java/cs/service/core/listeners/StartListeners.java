package cs.service.core.listeners;

import lombok.extern.log4j.Log4j2;
import vn.cs123.lib.system.SystemMain;
import vn.cs123.lib.utils.common.Log123CS;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

@Log4j2
public class StartListeners implements ServletContextListener {
    private static SystemMain _system;

    public static void InitContext() {

    }

    /**
     * Return the system main instance
     *
     * @return
     */
    public static SystemMain getSystem() {
        return _system;
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        System.out.println("contextInitialized");
        log.info("Initializing Ticket Management services.");
        Log123CS.init();
        _system = SystemMain.getInstance();
        _system.start();
    }


    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("contextDestroyed");
        log.info("Stopping Ticket Management services.");
        _system.stop();
    }
}
