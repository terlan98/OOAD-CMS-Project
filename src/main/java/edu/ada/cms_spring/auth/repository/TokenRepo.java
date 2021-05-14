package edu.ada.cms_spring.auth.repository;

import edu.ada.cms_spring.auth.model.Token;
import org.springframework.data.repository.CrudRepository;

public interface TokenRepo extends CrudRepository<Token, String>
{
}
