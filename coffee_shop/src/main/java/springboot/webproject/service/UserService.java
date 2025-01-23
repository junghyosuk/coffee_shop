package springboot.webproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.webproject.dto.UsersDTO;
import springboot.webproject.repository.UsersRepository;

import java.util.Optional;


public interface UserService {



    UsersDTO createUser(UsersDTO user); // 회원가입
    Optional<UsersDTO> login(String usersId, String usersPw); // 로그인
    Optional<UsersDTO> loginId(String usersId);
    // 추가: username으로 사용자 검색
    UsersDTO findUserByUsersId(String usersId);
}
