package com.ao.billms;

import com.ao.billms.entities.Provider;
import com.ao.billms.mapper.ProviderMapper;
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
    //get Provider
    ProviderMapper providerMapper;
    @Test
    public void contextLoads() {


    }

}
