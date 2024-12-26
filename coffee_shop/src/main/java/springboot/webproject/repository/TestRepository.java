package springboot.webproject.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.webproject.entity.TestEntity;

@Repository
public interface TestRepository extends JpaRepository<TestEntity, Long> {
}