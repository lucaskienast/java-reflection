package annotations.creationAndDiscovery;

import annotations.customAnnotations.InitializerClass;
import annotations.customAnnotations.InitializerMethod;

@InitializerClass
public class AutoSaver {

    @InitializerMethod
    public void startAutoSavingThreads() {
        System.out.println("Start auto data saving to disk");
    }

}
