package robotService;

import robotService.core.Engine;
import robotService.core.EngineImpl;

public class Main {
    public static void main(String[] args) {

        Engine engine;
        engine = new EngineImpl();
        engine.run();
    }
}
