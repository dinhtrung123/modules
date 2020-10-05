package com.blogspot.chingovan.database.service.persistence.impl;

import java.sql.Connection;
import java.util.List;

import com.blogspot.chingovan.database.model.impl.StudentImpl;
import com.blogspot.chingovan.database.service.persistence.GenericDAO;
import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.Dialect;
import com.liferay.portal.kernel.dao.orm.ORMException;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.spring.extender.service.ServiceReference;

public class AbstractDAO<T> implements GenericDAO<T> ,SessionFactory {
	 @ServiceReference(type = CustomSQL.class)
		private CustomSQL customSQL ;

	

	@SuppressWarnings("unchecked")
	public  List<T> query( String sql, String Entity , int start, int end, Object... parameters) {
		Session session = null ;
		
		try {
		
			  session=openSession();
			
			 System.out.println("ket qua" + sql);
			  SQLQuery sqlQuery=session.createSQLQuery(sql);
			  sqlQuery.setCacheable(false);
			  sqlQuery.addEntity(Entity, StudentImpl.class);
	           QueryPos queryPos=QueryPos.getInstance(sqlQuery);
	           for (Object object : parameters) {
				queryPos.add(object);
			 
			}   
	           
	           return (List<T>) QueryUtil.list(sqlQuery, getDialect(),start,end);
	           
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			   closeSession(session);
		}
		
		return null ;
	

	}



	@Override
	public void closeSession(Session session) throws ORMException {
		// TODO Auto-generated method stub
		
	}



	@Override
	public Session getCurrentSession() throws ORMException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Dialect getDialect() throws ORMException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Session openNewSession(Connection connection) throws ORMException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Session openSession() throws ORMException {
		// TODO Auto-generated method stub
		return null;
	}

}
