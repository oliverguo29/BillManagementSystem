package com.ao.billms.controller;

import com.ao.billms.dao.ProviderDao;
import com.ao.billms.entities.Provider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

@Controller
public class ProviderController {

    Logger logger = LoggerFactory.getLogger(getClass());    //log

    @Autowired
    ProviderDao providerDao;

    //show providers
   @GetMapping("/providers")
    public String show_list(Map<String,Object> map, @RequestParam(value="providerName",required = false)  String providerName){
       logger.info("provider info "+providerName);

       Collection<Provider> providers = providerDao.getAll(providerName);

       map.put("providers",providers);
       map.put("providerName",providerName);

       return "provider/list";
    }
    //show provider info and show provider info in update page
    @GetMapping("/provider/{pid}")
    public String get_view( @PathVariable("pid")Integer pid,
                            @RequestParam(value = "type", defaultValue= "view") String type,
                            Map<String,Object> map){
        logger.info(pid+"info");
        Provider provider = providerDao.getProvider(pid);
        map.put("provider",provider);
        //if type=null--> view,else-->update
        return "provider/"+type;
    }

    //update provider info
    @PutMapping("/provider")
    public String update(Provider provider){
        logger.info("update"+provider.getPid());
        //insert or update
        providerDao.save(provider);

       return "redirect:/providers";
    }


    //go to add page
    @GetMapping("/provider")
    public String toAddPage(){

       return "provider/add";
    }

    //add new provider
    @PostMapping("/provider")
    public  String addProvider(Provider provider){
        logger.info("add provider"+provider);
        providerDao.save(provider);
        return "redirect:/providers";
    }


    //delete provider
    @DeleteMapping("/provider/{pid}")
    public String delete(@PathVariable("pid") Integer pid){
            logger.info("delete"+pid);
            providerDao.delete(pid);

       return "redirect:/providers";
    }
}



