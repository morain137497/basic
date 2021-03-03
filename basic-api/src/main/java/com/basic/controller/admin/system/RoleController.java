package com.basic.controller.admin.system;
import com.basic.common.utils.ResUtils;
import com.basic.common.vo.ResVo;
import com.basic.entity.RoleEntity;
import com.basic.entity.UserEntity;
import com.basic.enums.UserSignEnum;
import com.basic.service.RoleService;
import com.basic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @user: jz
 * @date: 2021/2/24 上午9:01
 * @todo: 角色控制器类
 */
@RestController
@RequestMapping("/system")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/role")
    public ResVo create(
            @RequestBody RoleEntity roleEntity
            )
    {
        roleService.create(roleEntity);
        return ResUtils.success();
    }

    @DeleteMapping("/role/{id}")
    public ResVo delete(
            @PathVariable Long id
    )
    {
        roleService.delete(id);
        return ResUtils.success();
    }

    @PutMapping("/admin")
    public ResVo update(
            @RequestBody RoleEntity roleEntity
    )
    {
        roleService.update(roleEntity);
        return ResUtils.success();
    }

    @PutMapping("/role-status/{id}/{status}")
    public ResVo updateStatus(
            @PathVariable Long id,
            @PathVariable Integer status
    )
    {
        roleService.updateStatus(id, status);
        return ResUtils.success();
    }

    @PutMapping("/role-rule/{id}")
    public ResVo adminRole(
            @PathVariable Long id,
            @RequestParam(value = "ruleIdList", required = false) List<Long> ruleIdList
    )
    {
        roleService.adminRole(id, ruleIdList);
        return ResUtils.success();
    }
//
//    @GetMapping("/admin")
//    public ResVo list(
//            @RequestParam(value = "username", required = false) String username,
//            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
//            @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize
//    )
//    {
//        return ResUtils.success(userService.list(username,page,pageSize, Arrays.asList(UserSignEnum.SUPER_ADMIN.getValue(), UserSignEnum.ADMIN.getValue())));
//    }
}
