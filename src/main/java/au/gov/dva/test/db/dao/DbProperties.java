package au.gov.dva.test.db.dao;

import java.io.IOException;
import java.util.Properties;

public enum DbProperties {
    DB_TYPE("db.type"),
    DB_DRIVER_CLASS("db.driver_class"),
    DB_URL("db.url"),
    DB_USERNAME("db.username"),
    DB_PASSWORD("db.password"),
    SQL_AUTO_INCREMENT("sql.auto_increment");

    private final static Properties applicationProperties = new Properties();
    private static String propsFilename = "config/jdbc.properties";

    private final String key;

    static {
        try {
            applicationProperties.load(DbProperties.class.getClassLoader().getResourceAsStream(propsFilename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String val() {
        return applicationProperties.getProperty(key, "");
    }

    private DbProperties(String key) {
        this.key = key;
    }
}
