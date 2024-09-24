package org.acme.quickstart;

import io.quarkus.test.Mock;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.quickstart.service.RealExpensive;

@ApplicationScoped
@Mock
public class MockExpensiveService implements RealExpensive {
    @Override
    public int calculate() {
        return 20;
    }
}
