package com.bibliotheek.config;

import java.util.Optional;

public final class ExternalPropertyConfig {

    private ExternalPropertyConfig() {
        // private constructor
    }

    public static void loadExternalProperties(String property) {
        consoleLog("********************************************************");

        String config = Optional.ofNullable(System.getProperty(property)).orElseGet(() -> System.getenv(property));
        consoleLog("lookup: " + property + " -> '" + config + "'");

        if (config != null && !config.trim().equals("")) {
            consoleLog("using properties from : '" + config + "'");
            System.setProperty("spring.config.location", config);
        } else {
            consoleLog("using properties from war");
        }

        consoleLog("********************************************************");
    }

    /**
     * This method logs to system.out because the property loading must be the first thing the application does and therefore real
     * logging is not loaded yet.
     *
     * @param logLine log line in string
     */
    private static void consoleLog(String logLine) {
        System.out.println(logLine);
    }
}
