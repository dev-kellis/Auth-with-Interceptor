package kr.kellis.aawithinterceptor.app.service;

import kr.kellis.aawithinterceptor.app.dto.User;
import kr.kellis.aawithinterceptor.app.exception.InvalidAccountException;
import kr.kellis.aawithinterceptor.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUser(User user) {
        User loginUser = userRepository.findByUserIdAndPassword(user.getUserId(), user.getPassword());
        if(loginUser == null){
            throw new InvalidAccountException("잘못된 ID 혹은 Password를 입력하셨습니다.");
        }
        return loginUser;
    }
}
