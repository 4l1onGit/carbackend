package online.hasalidev.cardatabase.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(exported = false)
public interface AppUserRepository extends CrudRepository<AppUser, Long> {
    Optional<AppUser> findByUsername(String username);
}
