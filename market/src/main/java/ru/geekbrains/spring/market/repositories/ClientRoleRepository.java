package ru.geekbrains.spring.market.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.spring.market.models.ClientRole;

@Repository
public interface ClientRoleRepository extends JpaRepository<ClientRole, Long> {
}
