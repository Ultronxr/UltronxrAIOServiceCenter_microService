package cn.ultronxr.gameregister.service.impl;

import cn.ultronxr.gameregister.bean.mybatis.bean.Account;
import cn.ultronxr.gameregister.bean.mybatis.bean.AccountExample;
import cn.ultronxr.gameregister.bean.mybatis.mapper.AccountMapper;
import cn.ultronxr.gameregister.service.AccountService;
import com.alibaba.nacos.common.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ultronxr
 * @date 2022/11/29 18:56
 * @description
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper mapper;


    @Override
    public int createAccount(Account account) {
        account.setId(null);
        return mapper.insertSelective(account);
    }

    @Override
    public int deleteAccount(int id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateAccount(Account account) {
        return mapper.updateByPrimaryKeySelective(account);
    }

    @Override
    public List<Account> queryAccount(Account account) {
        AccountExample example = new AccountExample();
        AccountExample.Criteria criteria = example.createCriteria();

        if(StringUtils.isNotEmpty(account.getNick())) {
            criteria.andNickLike("%" + account.getNick() + "%");
        }
        if(StringUtils.isNotEmpty(account.getUsername())) {
            criteria.andNickLike("%" + account.getUsername() + "%");
        }
        if(StringUtils.isNotEmpty(account.getEmail())) {
            criteria.andNickLike("%" + account.getEmail() + "%");
        }
        if(StringUtils.isNotEmpty(account.getPhone())) {
            criteria.andNickLike("%" + account.getPhone() + "%");
        }
        if(StringUtils.isNotEmpty(account.getPlatform())) {
            criteria.andNickLike("%" + account.getPlatform() + "%");
        }
        if(StringUtils.isNotEmpty(account.getShop())) {
            criteria.andNickLike("%" + account.getShop() + "%");
        }
        if(StringUtils.isNotEmpty(account.getRegion())) {
            criteria.andNickLike("%" + account.getRegion() + "%");
        }

        return mapper.selectByExample(example);
    }
}
