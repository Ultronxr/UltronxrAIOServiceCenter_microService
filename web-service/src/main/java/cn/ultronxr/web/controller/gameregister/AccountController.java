package cn.ultronxr.web.controller.gameregister;

import cn.ultronxr.gameregister.bean.mybatis.bean.Account;
import cn.ultronxr.web.service.openfeignclient.gameregister.AccountClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Ultronxr
 * @date 2022/11/29 19:50
 * @description
 */
@Controller
@RequestMapping("/gameRegister/account")
public class AccountController {

    @Resource
    private AccountClient accountClient;


    @PostMapping("create")
    @ResponseBody
    public String createAccount(@RequestBody Account account) {
       return accountClient.createAccount(account);
    }

    @GetMapping("delete")
    @ResponseBody
    public String deleteAccount(@RequestParam("id") String id) {
        return accountClient.deleteAccount(id);
    }

    @PostMapping("update")
    @ResponseBody
    public String updateAccount(@RequestBody Account account) {
        return accountClient.updateAccount(account);
    }

    @PostMapping("query")
    @ResponseBody
    public List<Account> queryAccount(@RequestBody Account account) {
        return accountClient.queryAccount(account);
    }


}
