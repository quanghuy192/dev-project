package core;

import java.util.List;

public interface IRepository<ID extends Long, E extends BaseEntity> {

    E findOne(ID id);

    List<E> getAll();
}
