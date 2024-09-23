package org.acme.quickstart;

import org.eclipse.microprofile.config.spi.ConfigSource;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Con esta configuracion reemplazamos la configuracion de application.propeties
 */
public class InMemoryConfigSource implements ConfigSource {

    private Map<String, String> prop = new HashMap<>();

    public InMemoryConfigSource() {
        this.prop.put("greeting.message", "Hola mundo");
    }

    @Override
    public Map<String, String> getProperties() {
        return prop;
    }

    @Override
    public Set<String> getPropertyNames() {
        return Set.of();
    }

    /**
     * sirve para darle una preferencia de carga a los valores
     * @return
     */
    @Override
    public int getOrdinal() {
        return 900;
    }

    @Override
    public String getValue(String s) {
        return prop.get(s);
    }

    @Override
    public String getName() {
        return "InMemoryConfigSource";
    }
}
