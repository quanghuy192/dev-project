package core;

import java.util.List;

public interface IRepository<final ID extends Long, final E extends BaseEntity> {

    E findOne(ID id);

    List<E> getALl();
}
