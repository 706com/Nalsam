package user.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import user.domain.User;


public interface UserRepository extends JpaRepository<User,Long> {
}
