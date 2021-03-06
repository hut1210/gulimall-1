package com.atguigu.gulimall.order.dao;

import com.atguigu.gulimall.order.entity.OmsOrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author zrt
 * @email zrt@gmail.com
 * @date 2020-05-11 00:17:58
 */
@Mapper
public interface OmsOrderDao extends BaseMapper<OmsOrderEntity> {
	
}
