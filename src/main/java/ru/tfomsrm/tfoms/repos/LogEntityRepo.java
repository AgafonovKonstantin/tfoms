package ru.tfomsrm.tfoms.repos;

import org.springframework.data.repository.CrudRepository;
import ru.tfomsrm.tfoms.domain.LogEntity;

import java.util.List;

public interface LogEntityRepo extends CrudRepository<LogEntity, Long> {

    List<LogEntity> findById(String id);

}
