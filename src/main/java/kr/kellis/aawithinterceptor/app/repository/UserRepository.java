package kr.kellis.aawithinterceptor.app.repository;

import kr.kellis.aawithinterceptor.app.dto.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
    User findByUserIdAndPassword(String userId, String password);
}
