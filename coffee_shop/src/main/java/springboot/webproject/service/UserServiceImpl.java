package springboot.webproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.webproject.dto.Role;
import springboot.webproject.dto.UsersDTO;
import springboot.webproject.repository.RoleRepository;
import springboot.webproject.repository.UsersRepository;

import java.util.Optional;
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private final UsersRepository usersRepository;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;


    @Autowired
    public UserServiceImpl(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    @Transactional
    public UsersDTO createUser(UsersDTO user) {
        // 1. status를 강제로 2로 설정
        user.setUsersStatus(2);
        // 상태를 2로 설정 (일반 사용자)

        // 2. 유저를 먼저 저장
        usersRepository.save(user);

        // 3. role_id를 강제로 2로 설정 (일반 사용자 역할)
        Role role = roleRepository.findById(2)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Role ID"));

        // 4. 유저의 roles에 해당 role을 추가
        user.getRoles().add(role);  // roles 리스트에 role 추가

        // 5. 저장된 유저와 역할 정보가 `user_roles` 테이블에 자동으로 반영됨
        return usersRepository.save(user); // 회원 정보 저장
    }


    @Override
//    public Optional<UsersDTO> login(String usersId, String usersPw) {
//        //Spring Security에서는 비밀번호를 PasswordEncoder로 암호화하여 저장하고, 로그인 시 입력된 비밀번호와 저장된 암호화된 비밀번호를 비교해야 합니다.
//        return usersRepository.findByUsersIdAndUsersPw(usersId, usersPw); // 로그인 처리
//    }
    public Optional<UsersDTO> login(String usersId, String usersPw) {
        Optional<UsersDTO> userOptional = usersRepository.findByUsersId(usersId);
        if (userOptional.isPresent() && passwordEncoder.matches(usersPw, userOptional.get().getUsersPw())) {
            String encryptedPassword = userOptional.get().getUsersPw(); // 데이터베이스에 저장된 암호화된 비밀번호
            if (passwordEncoder.matches(usersPw, encryptedPassword)) {
                System.out.println("비밀번호 일치");
                return userOptional; // 로그인 성공
            } else {
                System.out.println("비밀번호 불일치");
            }
        } else {
            System.out.println("사용자 ID 없음");
        }
        return Optional.empty(); // 로그인 실패

    }
//            return userOptional;
//        }
//        return Optional.empty();
//
//
//    }


    @Override
    public Optional<UsersDTO> loginId(String usersId) {
        return usersRepository.findByUsersId(usersId);
    }

    @Override
    public UsersDTO findUserByUsersId(String usersId) {
        return usersRepository.findUserByUsersId(usersId)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + usersId));
    }
}