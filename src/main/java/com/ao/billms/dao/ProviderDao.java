package com.ao.billms.dao;


import com.ao.billms.entities.Provider;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.*;

@Repository
// put into the container
public class ProviderDao {

    private static Map<Integer, Provider> providerMap = null;
    private static Integer initId = 2006;

    static {
        providerMap = new HashMap<Integer, Provider>();

        providerMap.put(2001, new Provider(2001, "PR-AA", "梦学谷供应商111", "小张", "18888666981", "深圳软件园", "0911-0123456", "品质A"));
        providerMap.put(2002, new Provider(2002, "PR-BB", "梦学谷供应商222", "小李", "18888666982", "深圳软件园", "0911-0123453", "品质B"));
        providerMap.put(2003, new Provider(2003, "PR-CC", "梦学谷供应商333", "小白", "18888666983", "深圳软件园", "0911-0123454", "品质C"));
        providerMap.put(2004, new Provider(2004, "PR-DD", "梦学谷供应商444", "小梦", "18888666984", "深圳软件园", "0911-0123451", "品质D"));
        providerMap.put(2005, new Provider(2005, "PR-EE", "梦学谷供应商555", "小谷", "18888666985", "深圳软件园", "0911-0123452", "品质E"));

    }


    public void save(Provider provider){
        if(provider.getPid() == null){
            provider.setPid(initId++);
        }
        provider.setCreateDate(new Date());
        providerMap.put(provider.getPid(), provider);
    }

    public Collection<Provider> getAll(){

        return providerMap.values();
    }

    public Collection<Provider> getAll(String providerName){
        Collection<Provider> providers = getAll();

        //not null
        if( !StringUtils.isEmpty( providerName )) {
            int count = 0;
            for (Provider provider: providers) {
                //包含则存在
                if ( provider.getProviderName().toUpperCase().contains(  providerName.toUpperCase() ) ) {
                    count++;
                    //count>1 表示集合至少有一个存在的用户, 否则创建新的集合
                    providers = count > 1 ? providers : new ArrayList<Provider>();
                    providers.add(provider);
                }
            }
            //no such provider name return empty list
            if(count==0){
                providers=new ArrayList<Provider>();
            }


        }

        return providers;
    }

    public Provider getProvider(Integer pid){
        return providerMap.get(pid);
    }

    public void delete(Integer pid){
        providerMap.remove(pid);
    }
}
