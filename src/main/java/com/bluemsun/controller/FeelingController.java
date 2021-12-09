package com.bluemsun.controller;

import com.bluemsun.dto.JsonResult;
import com.bluemsun.entity.Activity;
import com.bluemsun.entity.Feeling;
import com.bluemsun.entity.User;
import com.bluemsun.service.FeelingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @program: activity_register
 * @description: 感悟
 * @author: Windlinxy
 * @create: 2021-12-08 18:40
 **/
@RequestMapping(
        value = "/feelings",
        produces = "application/json"
)
@RestController
public class FeelingController {
    @Autowired
    private FeelingService feelingService;


    /**
     * 提交活动记录
     *
     * @date 17:36 2021/12/8
     * @param request 请求
     * @param feeling 感悟
     * @return com.bluemsun.dto.JsonResult<com.bluemsun.entity.Activity>
     **/
    @PostMapping(
            consumes = "application/json"
    )
    public JsonResult<Feeling> submitFeeling(HttpServletRequest request, @RequestBody Feeling feeling) {
        //获取用户信息
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(session.getId());
        //确保用户使用自身账号
        feeling.setFeelingUser(user.getUsername());
        if(this.feelingIsRight(feeling) && feelingService.addFeeling(feeling) == 1 ){
            return new JsonResult<Feeling>().ok();
        }else {
            return new JsonResult<Feeling>().fail();
        }
    }

    /**
     * 获取该用户活动记录
     *
     * @date 17:36 2021/12/8
     * @param request 请求
     * @return com.bluemsun.dto.JsonResult<java.util.List<com.bluemsun.entity.Activity>>
     **/
    @GetMapping()
    public JsonResult<List<Feeling>> getFeeling(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute(session.getId());
        List<Feeling> list = feelingService.queryFeelingByUsername(user.getUsername());
        if(list != null){
            return new JsonResult<List<Feeling>>().ok(list);
        }else {
            return new JsonResult<List<Feeling>>().fail();
        }
    }

    /**
     * 删除活动
     *
     * @date 17:37 2021/12/8
     * @param id 感悟id
     * @return com.bluemsun.dto.JsonResult<java.lang.Object>
     **/
    @DeleteMapping(value = "/{id}")
    public JsonResult<Object> deleteFeeling(@PathVariable("id") int id){
        if(feelingService.deleteFeelingById(id) == 1){
            return new JsonResult<>().ok();
        }else {
            return new JsonResult<>().fail();
        }
    }

    /**
     * 修改感悟
     *
     * @date 17:37 2021/12/8
     **/
    @PatchMapping( consumes = "application/json")
    public JsonResult<Activity> changFeelingInfo(HttpServletRequest request, @RequestBody Feeling feeling) {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute(session.getId());
        feeling.setFeelingUser(user.getUsername());
        if(this.feelingIsRight(feeling) && feelingService.changeFeeling(feeling) == 1 ){
            return new JsonResult<Activity>().ok();
        }else {
            return new JsonResult<Activity>().fail();
        }
    }

    /**
     * 判断用户提交感悟是否符合要求
     *
     * @date 18:13 2021/12/8
     * @param feeling 活动记录
     * @return boolean 是否符合要求
     **/
    private boolean feelingIsRight(Feeling feeling) {
        if (feeling.getFeelingContent() == null) {
            return false;
        } else if (feeling.getFeelingUser() == null) {
            return false;
        } else if (feeling.getFeelingYear() == null) {
            return false;
        } else if(feeling.getFeelingMood() == null){
            return false;
        }else {
            return feeling.getFeelingSelfJud() != null;
        }
    }

}
