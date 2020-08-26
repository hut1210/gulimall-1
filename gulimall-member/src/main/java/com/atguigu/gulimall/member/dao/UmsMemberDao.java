package com.atguigu.gulimall.member.dao;

import com.atguigu.gulimall.member.entity.UmsMemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author zrt
 * @email zrt@gmail.com
 * @date 2020-05-11 00:16:10
 */
@Mapper
public interface UmsMemberDao extends BaseMapper<UmsMemberEntity> {
	
}
