package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DoorController {

    /**
     * 通用的页面跳转的 方法
     * 根据指定的 jsp界面的名字 跳转到指定的 jsp界面
     *
     * 优先级最低 ，当没有路径和 输入的路径匹配的时候才会 来这里找 jsp
     */
    @RequestMapping("/{page}")
    public String defaul(@PathVariable String page){

        return page;
    }

    /**
     * 1.查询所有门店的信息
     * 点击门店管理，访问 doorList
     * 执行 doorList 方法，查询所有门店信息，最后将门店信息带到 door_list.jsp 之中进行显示
     *
     * @return
     */

    @RequestMapping("/wcnm")
    public String a(){

        return  "a";
    }

    /**
     * 新增 门店的信息 doorAdd
     */



    /**
     * 删除门店信息  doorDelete
     */



    /**
     * 修改门店信息  ，首先查出 id的门店信息 ，然后将信息带给 door_update 进行回显 ，在update界面修改
     *
     * /doorInfo +  /doorUpdate
     */
}
