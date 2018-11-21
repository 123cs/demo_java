package guice;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new GuiceModule());
        AnimalService animalService = injector.getInstance(AnimalService.class);
        System.out.println(animalService.getName());
    }
}
