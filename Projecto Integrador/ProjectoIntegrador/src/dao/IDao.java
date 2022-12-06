package dao;

import java.util.List;

public interface IDao<T> {
    T guardar (T t);
    T buscar (Integer id);
    void actualizar (T t);
    void eliminar(Interger id);
    List<T> buscarTodo();
}
