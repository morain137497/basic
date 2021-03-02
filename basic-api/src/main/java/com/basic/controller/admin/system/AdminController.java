package com.basic.controller.admin.system;
import com.basic.common.utils.ResUtils;
import com.basic.common.vo.ResVo;
import com.basic.entity.UserEntity;
import com.basic.enums.UserSignEnum;
import com.basic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @user: jz
 * @date: 2021/2/24 上午9:01
 * @todo: 管理员控制器类
 */
@RestController
@RequestMapping("/system")
public class AdminController {

    @Autowired
    private UserService userService;

    @PostMapping("/admin")
    public ResVo create(
            @RequestBody UserEntity userEntity
            )
    {
        userService.create(userEntity);
        return ResUtils.success();
    }

    @DeleteMapping("/admin/{id}")
    public ResVo delete(
            @PathVariable Long id
    )
    {
        userService.delete(id);
        return ResUtils.success();
    }

    @PutMapping("/admin")
    public ResVo update(
            @RequestBody UserEntity userEntity
    )
    {
        userService.update(userEntity);
        return ResUtils.success();
    }

    @PutMapping("/admin-status/{id}/{status}")
    public ResVo updateStatus(
            @PathVariable Long id,
            @PathVariable Integer status
    )
    {
        userService.updateStatus(id, status);
        return ResUtils.success();
    }

    @PutMapping("/admin-role/{id}")
    public ResVo adminRole(
            @PathVariable Long id,
            @RequestParam(value = "roleIdList", required = false) List<Long> roleIdList
    )
    {
        userService.adminRole(id, roleIdList);
        return ResUtils.success();
    }

    @GetMapping("/admin")
    public ResVo list(
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize
    )
    {
        return ResUtils.success(userService.list(username,page,pageSize, Arrays.asList(UserSignEnum.SUPER_ADMIN.getValue(), UserSignEnum.ADMIN.getValue())));
    }
}
