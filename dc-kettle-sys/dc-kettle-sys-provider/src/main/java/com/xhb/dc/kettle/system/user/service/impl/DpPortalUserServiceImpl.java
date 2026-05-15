package com.xhb.dc.kettle.system.user.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xhb.dc.kettle.system.user.entity.DpPortalUser;
import com.xhb.dc.kettle.system.user.entity.UserRoleEntity;
import com.xhb.dc.kettle.system.user.mapper.DpPortalUserMapper;
import com.xhb.dc.kettle.system.user.service.DpPortalUserService;
import com.xhb.dc.kettle.system.common.utils.PageInfoUtil;
import com.xhb.dc.kettle.system.user.dto.UserDTO;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * DpPortalUserServiceImpl.
 */
@Service
public class DpPortalUserServiceImpl implements DpPortalUserService {

    private String redisKey = "userLogin";

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private DpPortalUserMapper dpPortalUserMapper;

    @Override
    public int deleteByPrimaryKey(String userId) {
        return dpPortalUserMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public int insert(DpPortalUser record) {
        return dpPortalUserMapper.insert(record);
    }

    @Override
    public int insertSelective(DpPortalUser record) {
        return dpPortalUserMapper.insertSelective(record);
    }

    @Override
    public DpPortalUser selectByPrimaryKey(String userId) {
        return dpPortalUserMapper.selectByPrimaryKey(userId);
    }

    @Override
    public int updateByPrimaryKeySelective(DpPortalUser record) {
        return dpPortalUserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(DpPortalUser record) {
        return dpPortalUserMapper.updateByPrimaryKey(record);
    }

    @Override
    public DpPortalUser selectByUserName(String userName) {
        return dpPortalUserMapper.selectByUserName(userName);
    }

    @Override
    public DpPortalUser selectLoginInfoByUserName(String userName) {
        return dpPortalUserMapper.selectLoginInfoByUserName(userName);
    }

    @Override
    public int deleteByUserId(String userId, String optId) {
        return dpPortalUserMapper.deleteByUserId(userId, optId);
    }

    @Override
    public Integer checkExistsByUserName(String userName) {
        return dpPortalUserMapper.checkExistsByUserName(userName);
    }

    @Override
    public int updateByUserNameSelective(DpPortalUser record) {
        return dpPortalUserMapper.updateByUserNameSelective(record);
    }

    @Override
    public PageInfo<UserDTO> selectUsers(String keyWord, Page<DpPortalUser> page, String userId) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<DpPortalUser> dpPortalUsers = dpPortalUserMapper.selectUsers(keyWord, userId);
        return PageInfoUtil.pageInfo2PageInfoDTO(new PageInfo<>(dpPortalUsers), UserDTO.class);
    }

    @Override
    public int deleteByUserIds(List<String> userIds, String createUserId) {
        return dpPortalUserMapper.deleteByUserIds(userIds, createUserId);
    }

    @Override
    public int getPasswordErrLongTime(String userName) {
        Object times = stringRedisTemplate.opsForValue().get(redisKey + "#" + userName);
        if (times != null) {
            return Integer.valueOf(times.toString());
        } else {
            return 0;
        }
    }

    @Override
    public void addPasswordErrLongTime(String userName) {
        Object object = stringRedisTemplate.opsForValue().get(redisKey + "#" + userName);
        if (object == null) {
            stringRedisTemplate.opsForValue().set(redisKey + "#" + userName, String.valueOf(1));
        } else {
            int time = Integer.valueOf(object.toString());
            time = time + 1;
            stringRedisTemplate.opsForValue().set(redisKey + "#" + userName, String.valueOf(time));

        }

    }

    @Override
    public void resetPasswordErrLongTime(String userName) {
        stringRedisTemplate.opsForValue().set(redisKey + "#" + userName, String.valueOf(0));

    }

    @Override
    public int updateStatus(String userId, int status) {
        return dpPortalUserMapper.updateStatus(userId, status);
    }

    @Override
    public int updateLastLoginTime(String userId, Date lastLoginTime) {
        return dpPortalUserMapper.updateLastLoginTime(userId, lastLoginTime);
    }

    @Override
    public List<UserRoleEntity> selectUserRoleByUserName(String userName) {
        return dpPortalUserMapper.selectUserRoleByUserName(userName);
    }

    @Override
    public List<DpPortalUser> selectAuditingUser(String userId) {
        return dpPortalUserMapper.selectAuditingUser(userId);
    }

}
