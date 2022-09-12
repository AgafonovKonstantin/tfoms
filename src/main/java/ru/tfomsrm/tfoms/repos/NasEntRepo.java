package ru.tfomsrm.tfoms.repos;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.tfomsrm.tfoms.domain.NasEnt;

import java.util.List;

public interface NasEntRepo extends CrudRepository<NasEnt, Long> {

    List<NasEnt> findById(String id);

    @Transactional
    @Modifying(flushAutomatically = true)
    @Query("update NasEnt e set e.status = :status where e.id = :id")
    void setStatusById(@Param("status")Integer status, @Param("id") Long id);

}
