package annotations.creationAndDiscovery.databases;

import annotations.customAnnotations.InitializerClass;
import annotations.customAnnotations.InitializerMethod;

@InitializerClass
public class CacheLoader {

    @InitializerMethod
    public void loadCache() {
        System.out.println("Loading data from cache");
    }

    public void reloadCache() {
        System.out.println("Reloading cache");
    }

}
