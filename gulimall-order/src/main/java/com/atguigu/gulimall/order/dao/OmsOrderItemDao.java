package com.atguigu.gulimall.order.dao;

import com.atguigu.gulimall.order.entity.OmsOrderItemEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单项信息
 * 
 * @author zrt
 * @email zrt@gmail.com
 * @date 2020-05-11 00:17:58
 */
@Mapper
public interface OmsOrderItemDao extends BaseMapper<OmsOrderItemEntity> {
	
}
