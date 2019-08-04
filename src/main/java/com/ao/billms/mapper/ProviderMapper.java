package com.ao.billms.mapper;

import com.ao.billms.entities.Provider;

import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 使用Mybatis注解版本
 */
//@Mapper //指定这是操作数据的Mapper
public interface ProviderMapper {

     //get Provider
     List<Provider> getProviders(Provider provider);

     //get ProviderById
     Provider getProviderById(int pid);

     //add provider
     int addProvider(Provider provider);

     //delete provider
     int deleteProviderById(int pid);

     //update provider
     int updateProvider(Provider provider);









//    @Select("select * from provider where pid=#{pid}")
//    Provider getProvierByPid(Integer pid);
//
//    //useGeneratedKeys是否使用自增主键，keyProperty指定实体类中的哪一个属性封装主键值
//    @Options(useGeneratedKeys = true, keyProperty = "pid")
//    @Insert("insert into provider(providerName) values(#{providerName})")
//    int addProvider(Provider provider);
//
//    @Delete("delete from provider where pid=#{pid}")
//    int deleteProviderByPid(Integer pid);
//
//    @Update("update provider set providerName=#{providerName} where pid=#{pid}"  )
//    int updateProvider(Provider provider);
}
