package com.leeveg.note.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

/**
 * 公共字段自动填充
 * 
 * @author blank
 *
 */
@Slf4j
@Component
// @ConditionalOnProperty(name = "fill.enabled", havingValue = "true")
public class MybatisPlusMetaObjectHandler implements MetaObjectHandler {

	@Override
	public void insertFill(MetaObject metaObject) {
		log.debug("start insert fill ....");
//		LoginUser user = SecurityUtil.getUser();
		String creator = "";
		String modifier = "";
//		if (user != null) {
//			creator = StringUtils.isNotBlank(user.getUsername()) ? user.getUsername() : "";
//			modifier = StringUtils.isNotBlank(user.getUsername()) ? user.getUsername() : "";
//		}
		this.setFieldValByName("creator", creator, metaObject);
		this.setFieldValByName("modifier", modifier, metaObject);

	}

	@Override
	public void updateFill(MetaObject metaObject) {
		log.debug("start update fill ....");
//		LoginUser user = SecurityUtil.getUser();
		String modifier = "";
//		if (user != null) {
//			modifier = StringUtils.isNotBlank(user.getUsername()) ? user.getUsername() : "";
//		}
		this.setFieldValByName("modifier", modifier, metaObject);
	}
}
