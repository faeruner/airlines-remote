package by.pvt.module4.client.common;

import org.springframework.beans.factory.InitializingBean;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SystemPropertiesInitializingBean implements InitializingBean {

    private Map<String, String> systemProperties;

    @Override
    public void afterPropertiesSet() throws Exception {
        if (null == systemProperties || systemProperties.isEmpty()) {
            return;
        }

        final Set<Entry<String, String>> entrySet = systemProperties.entrySet();
        for (final Entry<String, String> entry : entrySet) {

            final String key = entry.getKey();
            final String value = entry.getValue();

            System.setProperty(key, value);
        }

    }

    public void setSystemProperties(final Map<String, String> systemProperties) {
        this.systemProperties = systemProperties;
    }

}
