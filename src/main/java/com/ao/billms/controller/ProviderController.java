package com.ao.billms.controller;

import com.ao.billms.dao.ProviderDao;
import com.ao.billms.entities.Provider;
import com.ao.billms.mapper.ProviderMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Controller
public class ProviderController {

    Logger logger = LoggerFactory.getLogger(getClass());    //log

    @Autowired
    ProviderDao providerDao;

    @Autowired
    ProviderMapper providerMapper;

    //show providers search area
   @GetMapping("/providers")
    public String show_list(Map<String,Object> map, Provider provider){
       logger.info("provider info "+provider);

       List<Provider> providers = providerMapper.getProviders(provider);

       map.put("providers",providers);
       //display
       map.put("providerName",provider.getProviderName());

       return "provider/list";
    }
    //show provider info and show provider info in update page
    @GetMapping("/provider/{pid}")
    public String get_view( @PathVariable("pid")Integer pid,
                            @RequestParam(value = "type", defaultValue= "view") String type,
                            Map<String,Object> map){
        logger.info(pid+"info");
        Provider provider = providerMapper.getProviderById(pid);
        map.put("provider",provider);
        //if type=null--> view,else-->update
        return "provider/"+type;
    }

    //update provider info
    @PutMapping("/provider")
    public String update(Provider provider){
        logger.info("update"+provider.getPid());
        //insert or update
        providerMapper.updateProvider(provider);
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
        providerMapper.addProvider(provider);
        return "redirect:/providers";
    }


    //delete provider
    @DeleteMapping("/provider/{pid}")
    public String delete(@PathVariable("pid") Integer pid){
            logger.info("delete"+pid);
            providerMapper.deleteProviderById(pid);

       return "redirect:/providers";
    }


}



