package com.cy.store.controller;

import com.cy.store.entity.Address;
import com.cy.store.service.IAddressService;
import com.cy.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.nio.channels.SeekableByteChannel;
import java.util.List;

/** 处理收获地址请求的控制器类 */
@RestController
@RequestMapping("addresses")
public class AddressController extends BaseController {
    @Autowired
    private IAddressService addressService;

    @RequestMapping("add_new_address")
    public JsonResult<Void> addNewAddress(Address address, HttpSession session){
        //获取当前登录的用户id和用户名
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);

        //调用业务方法执行业务
        addressService.addNewAddress(uid,username,address);
        //响应成功
        return new JsonResult<Void>(OK);
    }

    @GetMapping("getAddress")
    public JsonResult<List<Address>> getByUid(HttpSession session){
        //获取当前用户的id
        Integer uid=getUidFromSession(session);
        //调用业务方法执行业务
        List<Address> data = addressService.getByUid(uid);
        //响应成功
        return new JsonResult<List<Address>>(OK,data);
    }

    @RequestMapping("{aid}/set_default")
    public JsonResult<Void> setDefault(@PathVariable("aid") Integer aid,HttpSession session){
        //获取当前登录的用户id和用户名
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        //调用业务方法执行业务
        addressService.setDefault(aid,uid,username);
        //响应成功
        return new JsonResult<Void>(OK);
    }

}
