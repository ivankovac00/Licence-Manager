package ba.sum.fpmoz.licencemanager.repository;

import ba.sum.fpmoz.licencemanager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import ba.sum.fpmoz.licencemanager.model.UserDto;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    User save(UserDto userDto);
}