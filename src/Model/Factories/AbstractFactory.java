package Model.Factories;

public interface AbstractFactory<T> {
    T create(String choice, String _name, int _id);
}
