CREATE TABLE `d_` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `creator` varchar(255) NOT NULL DEFAULT '' COMMENT '创建人',
  `modify_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `modifier` varchar(255) NOT NULL DEFAULT '' COMMENT '修改人',
  `sys_status` int(4) NOT NULL DEFAULT '1' COMMENT '是否有效：0->无效，1->有效',
  `comment` varchar(255) NOT NULL DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

