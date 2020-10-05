package test.porlet;

import java.util.List;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;

public class ModelUtil {
	public static <T> List<T> getOject(String webservice_url ,Class<T> clazz,String key){
		 String _ressult;
	   	  try {
	   	  // Configuration configuration = ConfigurationFactoryUtil.getConfiguration(PortalClassLoaderUtil.getClassLoader(), "portlet");
	   	   _ressult = RestUtil.callRestURL(webservice_url + key, "GET", 0);
	   	   JSONArray dmDv = JSONFactoryUtil.createJSONArray(_ressult);
	   	   List <T> listModel = JsonUtil.convertToPojo(dmDv, clazz);
	       return listModel ;
	   	  } catch (Exception e) {
	   	   // TODO Auto-generated catch block
	   	   e.printStackTrace();
	   	  }
	   	  return null ;
	}
	public static <T> JSONArray getOjectMA(String webservice_url, Class<T> clazz ,String key , String idns){
		 String _ressult;
	   	  try {
	   	  // Configuration configuration = ConfigurationFactoryUtil.getConfiguration(PortalClassLoaderUtil.getClassLoader(), "portlet");
	   	 

	   	   _ressult = RestUtil.callRestURL(webservice_url + key, "GET", 0);
	   	   JSONArray dmDv = JSONFactoryUtil.createJSONArray(_ressult);
	   	   List<T> donViPojosma = JsonUtil.convertToPojo(dmDv, clazz);
	   	   JSONArray jsonarr =	JsonUtil.convertToJson(donViPojosma);
	   	   
			return jsonarr ;  
	   	  } catch (Exception e) {
	   	   // TODO Auto-generated catch block
	   	   e.printStackTrace();
	   	  }
	 
		return null ;
	}


}
