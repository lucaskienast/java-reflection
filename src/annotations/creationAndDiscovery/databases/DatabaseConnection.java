package annotations.creationAndDiscovery.databases;

import annotations.customAnnotations.InitializerClass;
import annotations.customAnnotations.InitializerMethod;

@InitializerClass
public class DatabaseConnection {

    @InitializerMethod
    public void connectToDatabase1() {
        System.out.println("Connecting to database 1");
    }

    @InitializerMethod
    public void connectToDatabase2() {
        System.out.println("Connecting to database 2");
    }

}
