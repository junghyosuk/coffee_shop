package springboot.webproject.repository;

import jakarta.persistence.EntityManager;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import springboot.webproject.dto.UsersDTO;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class JpaUsersRepository implements UsersRepository{

    private final EntityManager em;

    public JpaUsersRepository(EntityManager em) {
        this.em = em;
    }


    @Override
    public Optional<UsersDTO> findByUsersId(String usersId) {
        UsersDTO users = em.find(UsersDTO.class, usersId);
        return Optional.ofNullable(users);
    }

    @Override
    public Optional<UsersDTO> findByUsersIdAndUsersPw(String usersId , String usersPw) {
        UsersDTO users = em.find(UsersDTO.class, usersId);

        return Optional.empty();
    }

    @Override
    public Optional<UsersDTO> findByUsersName(String usersName) {
        List<UsersDTO> result = em.createQuery(
                        "select m from UsersDTO m where m.users_Name = :users_Name",
                        UsersDTO.class)
                .setParameter("users_Name", usersName)
                .getResultList();

        return result.stream().findAny();
    }
    @Override
    public List<UsersDTO> findAll() {
        return em.createQuery("select m from UsersDTO m", UsersDTO.class)
                .getResultList();
    }

//    @Override
//    public int updatePasswordByUserId(String userId, String newPassword) {
//        return 0;
//    }
//
//    @Override
//    public int updateStatusByUserId(String userId, String status) {
//        return 0;
//    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends UsersDTO> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends UsersDTO> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<UsersDTO> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public UsersDTO getOne(Integer integer) {
        return null;
    }

    @Override
    public UsersDTO getById(Integer integer) {
        return null;
    }

    @Override
    public UsersDTO getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends UsersDTO> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends UsersDTO> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends UsersDTO> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends UsersDTO> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends UsersDTO> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends UsersDTO> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends UsersDTO, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends UsersDTO> S save(S entity) {
        return null;
    }

    @Override
    public <S extends UsersDTO> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<UsersDTO> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public List<UsersDTO> findAll(Sort sort) {
        return List.of();
    }
    @Override
    public boolean existsById(Integer integer) {
        return false;
    }


    @Override
    public List<UsersDTO> findAllById(Iterable<Integer> integers) {
        return List.of();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(UsersDTO entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends UsersDTO> entities) {

    }

    @Override
    public void deleteAll() {

    }


    @Override
    public Page<UsersDTO> findAll(Pageable pageable) {
        return null;
    }
}