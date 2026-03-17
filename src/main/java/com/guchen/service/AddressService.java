package com.guchen.service;

import com.guchen.pojo.Address;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guchen.utils.Result;

/**
* @author Administrator
* @description 针对表【address(收货地址表)】的数据库操作Service
* @createDate 2026-03-16 19:02:06
*/
public interface AddressService extends IService<Address> {
    Result selectAddressI();
    Result addressUpdateInsert(Address address);
    Result addressDelete(Address address);
}
