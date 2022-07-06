package com.cy.store.service;

import com.cy.store.entity.Address;

import java.util.List;

/** 处理收获地址数据的业务层接口*/
public interface IAddressService {
    /**
     * 新增收获地址
     * @param uid 用户id
     * @param username 用户名
     * @param address 收获地址数据
     */
    void addNewAddress(Integer uid, String username, Address address);

    /**
     * 该用户拥有的收获地址列表数据
     * @param uid 用户id
     * @return 收获地址列表数据
     */
    List<Address> getByUid(Integer uid);
}
