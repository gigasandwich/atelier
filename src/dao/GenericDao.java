package dao;
import java.util.List;

public interface GenericDao<T> {
    List<T> selectAll();
    T select(int id);
    void insert(T entity);
    void update(T oldEntity, T newEntity);
    void delete(int id);
}