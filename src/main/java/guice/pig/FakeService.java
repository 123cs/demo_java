package guice.pig;

import guice.AnimalService;

public class FakeService implements AnimalService {
    @Override
    public String getName() {
        return "this is fake animal";
    }
}
