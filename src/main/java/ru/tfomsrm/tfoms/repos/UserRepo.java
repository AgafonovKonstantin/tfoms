package ru.tfomsrm.tfoms.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tfomsrm.tfoms.domain.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
