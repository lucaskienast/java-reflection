package annotations.creationAndDiscovery.http;

import annotations.customAnnotations.InitializerClass;
import annotations.customAnnotations.InitializerMethod;

@InitializerClass
public class ServiceRegistry {

    @InitializerMethod
    public void registerService() {
        System.out.println("Service successfully registered");
    }

}
