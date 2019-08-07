package com.ao.billms.controller;


import com.ao.billms.entities.Bill;
import com.ao.billms.entities.BillProvider;
import com.ao.billms.entities.Provider;
import com.ao.billms.mapper.BillMapper;
import com.ao.billms.mapper.ProviderMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@Controller
public class BillController {
    Logger logger = LoggerFactory.getLogger(getClass());


    @Autowired
    ProviderMapper providerMapper;

    @Autowired
    BillMapper billMapper;

    @GetMapping("/bills")
    public String list(Map<String, Object> map, Bill bill) {
        logger.info("Bills" + bill);
        List<BillProvider> billProviders;
        if(bill.getBillName()==null&&bill.getPid()==0&&bill.getPay()==null){
            billProviders = billMapper.getBills(null);
        }else{
            billProviders = billMapper.getBills(bill);
        }



        //get provider
        List<Provider> providers = providerMapper.getProviders(null);

        map.put("billProviders", billProviders);
        map.put("providers", providers);

        //re-display
        map.put("billName", bill.getBillName());
        map.put("pid", bill.getPid());
        map.put("pay", bill.getPay());

        return "bill/list";
    }

   /* *//**
     * type = null 进入查看详情页面view.html，
     * type=update 则是进入update.html
     * @return
     */
    @GetMapping("/bill/{bid}")
    public String view(@PathVariable("bid") Integer bid,
                       @RequestParam(value="type", defaultValue = "view") String type,
                       Map<String, Object> map) {
        logger.info("查询" + bid + "的详细信息");

        BillProvider billProvider = billMapper.getBillByBid(bid);

        if( "update".equals(type)) {
            List<Provider> providers = providerMapper.getProviders(null);
            map.put("providers", providers);
        }

        map.put("billProvider", billProvider);

        // type = null 则进入view.html， type=update 则是进入update.html
        return "bill/" + type;
    }

    //修改信息
    @PutMapping("/bill")
    public String update(Bill bill) {
        logger.info("更改信息。。。");
        //更新操作
        billMapper.updateBill(bill);

        return "redirect:bills";
    }

    //前往添加 页面
    @GetMapping("/bill")
    public String toAddPage(Map<String, Object> map) {
        //查询所有供应端
//        List<Provider> providers = providerMapper.getProviders(null);
        map.put("providers", providerMapper.getProviders(null) );
        return "bill/add";
    }


    //添加数据
    @PostMapping("/bill")
    public String add(Bill bill) {
        logger.info("添加数据" + bill);
        //保存数据操作
        billMapper.addBill(bill);

        return "redirect:/bills";
    }

    //删除
    @DeleteMapping("/bill/{bid}")
    public String delete(@PathVariable("bid") Integer bid) {
        logger.info("删除操作, bid=" + bid);
        billMapper.deteleBillByBid(bid);
        return "redirect:/bills";
    }

}
