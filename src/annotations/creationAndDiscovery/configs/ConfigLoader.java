package annotations.creationAndDiscovery.configs;

import annotations.customAnnotations.InitializerClass;
import annotations.customAnnotations.InitializerMethod;

@InitializerClass
public class ConfigLoader {

    @InitializerMethod
    public void loadAllConfigs() {
        System.out.println("Loading all configuration files");
    }

}
