package com.ao.billms.mapper;

import com.ao.billms.entities.Bill;
import com.ao.billms.entities.BillProvider;
import com.ao.billms.entities.Provider;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;


//@Mapper 或 @MapperScan
public interface BillMapper {
    // show bill info
    List<BillProvider> getBills(Bill bill);
    //getBillByBid
    BillProvider getBillByBid(Integer bid);
    //addBill
    int addBill(Bill bill);
    //updateBill
    int updateBill(Bill bill);
    //deleteBill
    int deteleBillByBid(int bid);




}
