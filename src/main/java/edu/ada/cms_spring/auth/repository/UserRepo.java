package edu.ada.cms_spring.auth.repository;

import edu.ada.cms_spring.auth.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, String>
{
	User findByEmail(String email);
	User findByEmailAndPassword(String email, String password);
}
