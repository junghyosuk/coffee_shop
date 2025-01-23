package springboot.webproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.webproject.dto.UsersDTO;

import java.util.List;
import java.util.Optional;



@Repository
public interface UsersRepository extends JpaRepository<UsersDTO, Integer> {

    Optional<UsersDTO> findByUsersId(String usersId);
    Optional<UsersDTO> findByUsersIdAndUsersPw(String usersId, String usersPw);

    Optional<UsersDTO> findByUsersName(String usersName);

//        int updatePasswordByUserId(String userId, String newPassword);

    //        int updateStatusByUserId(String userId, String status);
    List<UsersDTO> findAll();


    // 추가: username으로 검색하는 메서드
    Optional<UsersDTO> findUserByUsersId(String usersId);

}






//    int insertUsers(UsersDTO users);
//    UsersDTO selectUsersById(String id);
//    UsersDTO selectUsersByNo(int no);
//    int updateLastLogin(int no);
//    int updateUsers(UsersDTO users);
//    int updatePassword(UsersDTO users);
//    int updateStatus(UsersDTO users);
//    UsersDTO selectUsersId(UsersDTO users);
//    UsersDTO selectUsersNo(UsersDTO users);
//    int updateNewPassword(String users_id,String  newPasswword);
