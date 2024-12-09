package tech.reliab.course.stepanovsnLab.bank.service;

import tech.reliab.course.stepanovsnLab.bank.entity.User;
import tech.reliab.course.stepanovsnLab.bank.model.UserRequest;

import java.util.List;

public interface UserService {
    void requestUserInfo();

    User createUser(UserRequest userRequest);

    void deleteUser(int id);

    User updateUser(int id, String name);

    User getUserDtoById(int id);

    List<User> getAllUsers();
}