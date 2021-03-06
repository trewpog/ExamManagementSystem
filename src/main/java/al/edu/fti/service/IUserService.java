package al.edu.fti.service;

import al.edu.fti.entity.User;

import java.util.List;

public interface IUserService {

    User getUser(String username, String password);
    User getUserById(Long idUser);
    User createUpdateLecturer(User userLecturer);
    User createUpdateStudent(User userStudent);
    List<User> getAllLecturer();
    List<User> getAllStudent();
    void update(User user);
}
