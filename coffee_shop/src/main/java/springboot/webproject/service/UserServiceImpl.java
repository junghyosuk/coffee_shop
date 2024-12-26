package springboot.webproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.webproject.dto.UsersDTO;
import springboot.webproject.repository.UsersRepository;

import java.util.Optional;
@Service
public class UserServiceImpl implements UserService{

    private final UsersRepository usersRepository;
    @Autowired
    public UserServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    @Transactional
    public UsersDTO createUser(UsersDTO user) {
        return usersRepository.save(user); // 회원 정보 저장
    }


    @Override
    public Optional<UsersDTO> login(String usersId, String usersPw) {
        return usersRepository.findByUsersIdAndUsersPw(usersId, usersPw); // 로그인 처리
    }
}