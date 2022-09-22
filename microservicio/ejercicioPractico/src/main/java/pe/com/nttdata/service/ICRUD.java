package pe.com.nttdata.service;

import java.util.List;

public interface ICRUD<T, V> {

    T registrar(T obj);
    T modificar(T obj);
    T editar(T obj);
    List<T> listar();
    T listarPorId(V id);
    boolean eliminar(V id);
}
