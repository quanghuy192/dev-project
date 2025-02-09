package core;

import java.util.List;

public interface IRepository<E extends BaseEntity> {

    E findOne(Long id);

    List<E> getAll();
}
