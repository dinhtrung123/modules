package com.blogspot.chingovan.database.service.persistence;

import java.util.List;

import com.liferay.portal.kernel.dao.orm.SessionFactory;

public interface GenericDAO<T> {
    
	<T> List<T> query( String sql , String Entity , int start , int end , Object... parameters); 
}
