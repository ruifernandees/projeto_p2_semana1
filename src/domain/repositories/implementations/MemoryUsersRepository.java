package domain.repositories.implementations;

import java.util.ArrayList;

import domain.dtos.FindByLoginDTO;
import domain.entities.User;
import domain.repositories.IUsersRepository;
import infra.singletons.DatabaseConnection;

public class MemoryUsersRepository implements IUsersRepository {

    DatabaseConnection connection;

    public MemoryUsersRepository() {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public ArrayList<User> findAll() {
        return this.connection.getMemoryDatabase().users;
    }

    @Override
    public FindByLoginDTO findByLogin(String login) {
        ArrayList<User> users = this.connection.getMemoryDatabase().users;
        for (int i = 0; i < users.size(); i++) {
            User currentUser = users.get(i);
            if (currentUser.login.equals(login)) {
                return new FindByLoginDTO(currentUser, i);
            }
        }
        return null;
    }

    @Override
    public void create(User user) {
        this.connection.getMemoryDatabase().users.add(user);
    }

    @Override
    public void update(User user) {
        FindByLoginDTO userDTO = this.findByLogin(user.login);
        this.connection.getMemoryDatabase().users.set(userDTO.userIndex, user);
    }

    @Override
    public User findByIndex(Integer index) {
        ArrayList<User> users = this.connection.getMemoryDatabase().users;
        return users.get(index);
    }

    
}
