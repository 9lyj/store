package com.cy.store.mapper;

import com.cy.store.entity.Address;

import java.util.List;

/** 处理收获地址数据的持久层接口*/
public interface AddressMapper {
    /**
     * 新增收货地址数据
     * @param address 收获地址数据
     * @return 返回影响的行数
     */
    Integer insert(Address address);

    /**
     * 根据用户的id统计地址数量
     * @param uid 用户id
     * @return 当前用户的收货地址总数
     */
    Integer countByUid(Integer uid);
    /**
     *查询某用户的收获地址列表
     * @param uid 用户id
     * @return 该用户的地址列表数据
     */
    List<Address> findByUid(Integer uid);
}
