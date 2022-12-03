package cn.ultronxr.web.service.openfeignclient.gameregister;

import cn.ultronxr.gameregister.bean.mybatis.bean.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Ultronxr
 * @date 2022/11/30 15:56
 * @description OpenFeign 客户端；<br/>
 *              {@code @FeignClient()} 注解指定了在注册中心注册的服务名称；<br/>
 *              + 其内的每一个接口都使用 {@code @RequestMapping() / @GetMapping() / @PostMapping()} 指向该服务对应的 Controller；<br/>
 *              + 其内的每一个接口形参必须加 {@code @RequestParam("xx") / @RequestBody / @SpringQueryMap} 注解，否则会导致调用的 Controller 接收不到参数！
 */
@FeignClient("game-register-service")
public interface AccountClient {

    /**
     * 指向 {@code game-register-service} 服务对应的 {@code /account/create} Controller <br/>
     * 即：{@link cn.ultronxr.gameregister.controller.AccountController#createAccount(Account)}
     */
    @PostMapping("/account/create")
    @ResponseBody
    String createAccount(@RequestBody Account account);

    @GetMapping("/account/delete")
    @ResponseBody
    String deleteAccount(@RequestParam("id") String id);

    @PostMapping("/account/update")
    @ResponseBody
    String updateAccount(@RequestBody Account account);

    @PostMapping("/account/query")
    @ResponseBody
    List<Account> queryAccount(@RequestBody Account account);

}
