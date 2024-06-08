package ba.sum.fpmoz.licencemanager.service;

import ba.sum.fpmoz.licencemanager.entity.User;
import ba.sum.fpmoz.licencemanager.model.UserDto;

public interface UserService {
    User findByUsername(String username);

    User save(UserDto userDto);
}