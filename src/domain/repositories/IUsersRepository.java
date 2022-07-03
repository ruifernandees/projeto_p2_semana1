package domain.repositories;

import java.util.ArrayList;

import domain.dtos.FindByLoginDTO;
import domain.dtos.FindByUsernameDTO;
import domain.entities.User;

public interface IUsersRepository {
    public ArrayList<User> findAll();
    public FindByLoginDTO findByLogin(String login);
    public FindByUsernameDTO findByUsername(String username);
    public User findByIndex(Integer index);
    public void create(User user);
    public void update(User user);
}
