package com.cy.store.mapper;

import com.cy.store.entity.Address;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
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

    /**
     * 将某用户的所有收货地址设置为非默认地址
     * @param uid 收货地址归属的用户id
     * @return 受影响的行数
     */
    Integer updateNonDefaultByUid(Integer uid);

    /**
     * 将指定的收货地址设置为默认地址
     * @param aid 收货地址id
     * @param modifiedUser 修改执行人
     * @param modifiedTime 修改时间
     * @return 受影响的行数
     */
    Integer updateDefaultByAid(
            @Param("aid") Integer aid,
            @Param("modifiedUser") String modifiedUser,
            @Param("modifiedTime") Date modifiedTime);

    /**
     * 根据收货地址aid值，查询收货地址详情
     * @param aid 收货地址id
     * @return 匹配的收货地址详情，如果没有匹配的数据，则返回null
     */
    Address findByAid(Integer aid);
}
