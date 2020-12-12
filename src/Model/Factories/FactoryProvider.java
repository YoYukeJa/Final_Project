package Model.Factories;

public class FactoryProvider {
    public static Object getFactory(String choice){//, String _name, int _id){
        if ("user".equalsIgnoreCase(choice)){
            return new UserFactory();
        } else if ("group".equalsIgnoreCase(choice)){
            return new GroupFactory();
        } else if ("ticket".equalsIgnoreCase(choice)){
            return new TicketFactory();
        }
        return null;
    }
}
