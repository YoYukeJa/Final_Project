package Model.Factories;

public interface AbstractUserFactory<T> {
    T create(String choice, String _name, int _id, int hash);
}
