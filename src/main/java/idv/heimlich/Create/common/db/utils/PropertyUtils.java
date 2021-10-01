package idv.heimlich.Create.common.db.utils;

import java.util.Map;

import org.apache.commons.beanutils.PropertyUtilsBean;

public class PropertyUtils {

	public static Object copy(Map<?, ?> sourc, Object bean) {

		final PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();

		try {
			propertyUtilsBean.copyProperties(bean, sourc);
		} catch (final Exception e) {
			e.printStackTrace();
		}
		return bean;
	}

}
