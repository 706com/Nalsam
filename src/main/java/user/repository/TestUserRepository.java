package user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import user.domain.Test;

@Repository
public interface TestUserRepository extends JpaRepository<Test,Long> {
}
