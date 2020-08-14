package com.contrastsecurity;

import java.util.Set;

public class TestApplication extends javax.ws.rs.core.Application {

    @Override
    public Set<Class<?>> getClasses() {
        return Set.of(JerseyEndpoint.class, AdditionEndpoint.class);
    }

}
