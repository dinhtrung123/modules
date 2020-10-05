package com.trung.portlet;

import java.util.List;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;



public class ModelUtil {
	public static List<DonViPojo> getOject(){
		 String _ressult;
	   	  try {
	   	  // Configuration configuration = ConfigurationFactoryUtil.getConfiguration(PortalClassLoaderUtil.getClassLoader(), "portlet");
	   	   String webservice_url ="http://idm.vnu.edu.vn:8083";

	   	   _ressult = RestUtil.callRestURL(webservice_url + "/getSoBaiBaoGioGD", "GET", 0);
	   	   JSONArray dmDv = JSONFactoryUtil.createJSONArray(_ressult);
	   	   List < DonViPojo > donViPojos = JsonUtil.convertToPojo(dmDv, DonViPojo.class);
	       return donViPojos ;
	   	  } catch (Exception e) {
	   	   // TODO Auto-generated catch block
	   	   e.printStackTrace();
	   	  }
	   	  return null ;
	}
	public static JSONArray getOjectMA(String idns){
		 String _ressult;
	   	  try {
	   	  // Configuration configuration = ConfigurationFactoryUtil.getConfiguration(PortalClassLoaderUtil.getClassLoader(), "portlet");
	   	   String webservice_url ="http://idm.vnu.edu.vn:8083";

	   	   _ressult = RestUtil.callRestURL(webservice_url + "/getBaiBaoByMaCB?maCanBo="+idns+"", "GET", 0);
	   	   JSONArray dmDv = JSONFactoryUtil.createJSONArray(_ressult);
	   	   List<DonViPojoMA> donViPojosma = JsonUtil.convertToPojo(dmDv, DonViPojoMA.class);
	   	   JSONArray jsonarr =	JsonUtil.convertToJson(donViPojosma);
	   	   
			return jsonarr ;  
	   	  } catch (Exception e) {
	   	   // TODO Auto-generated catch block
	   	   e.printStackTrace();
	   	  }
	 
		return null ;
	}

}
