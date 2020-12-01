package Model.Factories;

public class FactoryProvider {
    public static AbstractFactory getFactory(String choice){//, String _name, int _id){
        if ("user".equalsIgnoreCase(choice)){
            return new UserFactory();
        } else if ("group".equalsIgnoreCase(choice)){
            return null;
        }
        return null;
    }
}
