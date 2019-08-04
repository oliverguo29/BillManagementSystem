package com.ao.billms.mapper;

import com.ao.billms.entities.Bill;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;


//@Mapper 或 @MapperScan
public interface BillMapper {

    Bill getBillByBid(Integer bid);

    int addBill(Bill bill);



}
