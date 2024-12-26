package springboot.webproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springboot.webproject.entity.TestEntity;
import springboot.webproject.service.TestService;

import java.util.List;

@RestController
public class TestController {

    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/test")
    public List<TestEntity> getAllEntities() {
        return testService.getAllEntities();
    }

    @PostMapping("/test")
    public TestEntity addEntity(@RequestParam String name) {
        return testService.saveEntity(name);
    }
}
/*-- 테이블 생성
CREATE TABLE test_entity (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) DEFAULT NULL
);

-- 데이터 삽입
INSERT INTO test_entity (name) VALUES ('First Name');
INSERT INTO test_entity (name) VALUES ('Second Name');

-- 테이블 확인
SELECT * FROM test_entity;
* */