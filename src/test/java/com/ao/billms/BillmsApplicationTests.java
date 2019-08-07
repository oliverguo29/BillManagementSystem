package com.ao.billms;

import com.ao.billms.entities.Bill;
import com.ao.billms.entities.BillProvider;
import com.ao.billms.entities.Provider;
import com.ao.billms.entities.User;
import com.ao.billms.mapper.BillMapper;
import com.ao.billms.mapper.ProviderMapper;
import com.ao.billms.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BillmsApplicationTests {

    @Autowired
    ProviderMapper providerMapper;



    @Autowired
    BillMapper billMapper;

    @Autowired
    UserMapper userMapper;
    @Test
    public void testBill() {
        User u = new User();
        u.setUsername("dsadasdas");
        int i = userMapper.addUser(u);
        System.out.println(i);

    }


}
