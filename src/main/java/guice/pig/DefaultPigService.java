package guice.pig;

import guice.AnimalService;

public class DefaultPigService implements AnimalService {

    @Override
    public String getName() {
        return "this is a pig";
    }
}
