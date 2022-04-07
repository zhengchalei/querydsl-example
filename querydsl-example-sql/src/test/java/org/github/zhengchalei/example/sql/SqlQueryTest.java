package org.github.zhengchalei.example.sql;

import com.github.zhengchalei.example.sql.domain.QUser;
import com.querydsl.sql.SQLQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@SpringBootTest
public class SqlQueryTest {

    @Autowired
    SQLQueryFactory sqlQueryFactory;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    @Transactional
    public void test() {
        QUser user = QUser.user;
        this.sqlQueryFactory
                .select(user.id, user.name)
                .from(user)
                .where(user.name.like("%a%"))
                .fetch()
                .forEach(data -> log.info("data: {}", data));
    }

}
