package com.cy.store.mapper;
import com.cy.store.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest //表示当前的类是一个测试类，不会随同项目打包发送
//@RunWith(SpringRunner.class) //启动当前单元测试类，需要传递一个参数，必须是SpringRunner的实例类型
public class UserMapperTests {

    //userMapper会报红，是因为idea检测到接口是不能直接创建bean的，但可以忽略
    @Autowired //自动装配
    private UserMapper userMapper;
    /*
    单元测试方法需要满足的条件：
        1.必须被@Test注解修饰
        2.返回值类型必须是void
        3.方法的参数列表不指定任何类型
        4.方法的访问修饰符必须是public
     */
    @Test
    public void insert() {
        User user = new User();
        user.setUsername("Tom");
        user.setPassword("111");
        Integer rows = userMapper.insert(user);
        System.out.println(rows);//输出1
    }
    @Test
    public void findByUsername() {
        User tom = userMapper.findByUsername("Tom");
        System.out.println(tom);//输出User(uid=1, username=Tom, password=111, salt=null, phone=null, email=null, gender=null, avatar=null, isDelete=false)

    }
}
