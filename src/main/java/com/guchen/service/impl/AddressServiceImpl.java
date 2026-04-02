package com.guchen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guchen.pojo.Address;
import com.guchen.service.AddressService;
import com.guchen.mapper.AddressMapper;
import com.guchen.utils.JwtHelper;
import com.guchen.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
* @author Administrator
* @description 针对表【address(收货地址表)】的数据库操作Service实现
* @createDate 2026-03-16 19:02:06
*/
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address>
    implements AddressService{

    @Autowired
    HttpServletRequest request;

    @Autowired
    JwtHelper jwtHelper;

    @Autowired
    AddressMapper addressMapper;

    @Override
    public Result selectAddressI() {
        String token = request.getHeader("token");
        Long userId = jwtHelper.getUserId(token);
        LambdaQueryWrapper<Address> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Address::getUserId, userId);
        List<Address> addressList = addressMapper.selectList(queryWrapper);
        if(addressList.isEmpty()) return Result.error("用户没有地址！");
        Result result = Result.ok("获取用户地址成功！");
        result.put("addressList", addressList);
        return result;
    }

    @Override
    public Result addressUpdateInsert(Address address) {
        Long userId = jwtHelper.getUserId(request.getHeader("token"));
        LambdaUpdateWrapper<Address> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(Address::getUserId, userId);
        List<Address> addressList = addressMapper.selectList(wrapper);
        if(!addressList.isEmpty()) {
            for(Address address2 : addressList) {
                address2.setIsDefault(0);
                addressMapper.updateById(address2);
            }
        }
        LambdaQueryWrapper<Address> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Address::getId, address.getId());
        Address address1 = addressMapper.selectOne(queryWrapper);
        address.setUpdatedAt(new Date());
        if(address1 == null) {
            address.setUserId(userId);
            address.setCreatedAt(new Date());
            addressMapper.insert(address);
            return Result.ok("添加用户地址成功！");
        }
        addressMapper.update(address, queryWrapper);
        return Result.ok("更新用户地址成功！");
    }

    @Override
    public Result addressDelete(Address address) {
        int n = addressMapper.deleteById(address.getId());
        if(n < 0) return Result.error("数据库中没有这条数据！");
        return Result.ok("删除用户地址成功！");
    }

    @Override
    public Result addressUpdateIsDefault(Address address) {
        Long userId = jwtHelper.getUserId(request.getHeader("token"));
        LambdaUpdateWrapper<Address> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(Address::getUserId, userId);
        List<Address> addressList = addressMapper.selectList(wrapper);
        if(!addressList.isEmpty()) {
            for(Address address2 : addressList) {
                address2.setIsDefault(0);
                addressMapper.updateById(address2);
            }
        }
        LambdaUpdateWrapper<Address> wrapper1 = new LambdaUpdateWrapper<>();
        wrapper1.eq(Address::getId, address.getId());
        Address address1 = addressMapper.selectOne(wrapper1);
        address1.setIsDefault(1);
        address1.setUpdatedAt(new Date());
        addressMapper.update(address1, wrapper1);
        return Result.ok("默认地址确定成功！");
    }
}




