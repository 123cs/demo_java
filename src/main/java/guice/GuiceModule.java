package guice;

import com.google.inject.AbstractModule;
import guice.pig.FakeService;

public class GuiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(AnimalService.class).to(FakeService.class);
    }
}
