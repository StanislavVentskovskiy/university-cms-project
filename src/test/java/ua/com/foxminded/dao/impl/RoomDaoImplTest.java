package ua.com.foxminded.dao.impl;

import org.junit.runner.RunWith;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@Sql(scripts = {"test-data.sql",""})

public class RoomDaoImplTest {
}
