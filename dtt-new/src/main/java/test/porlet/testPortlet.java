package test.porlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=dtt-new Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class testPortlet extends MVCPortlet {
private Log log = LogFactoryUtil.getLog(this.getClass().getName());
	
	@Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
    		throws IOException, PortletException {
		 String key = "/getSoBaiBaoGioGD" ;
		List<DonViPojo> listModel = ModelUtil.getOject(SystemConstant.URL, DonViPojo.class, key) ; 
   	    renderRequest.setAttribute("list",listModel);
   	    super.doView(renderRequest, renderResponse);
   	 
    
    }
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		 
		String resourceId = resourceRequest.getResourceID();
		if("baseResourceUrl".equals(resourceId))
		{
			String idns = ParamUtil.getString(resourceRequest, "idns") ;
			String key =  "/getBaiBaoByMaCB?maCanBo="+idns+"" ; 
			JSONArray jsonarr =  ModelUtil.getOjectMA(SystemConstant.URL,DonViPojoMA.class, key, idns) ;
			System.out.println("idddd" + idns);
			PrintWriter writer = resourceResponse.getWriter();
			 writer.write(jsonarr.toJSONString());
		} else if("getCbByTuoi".equals(resourceId))
		{
			 String key = "/getSoBaiBaoGioGD" ;
			String tuoi = ParamUtil.getString(resourceRequest, "tuoi");
		List<DonViPojo> list = ModelUtil.getOject(SystemConstant.URL, DonViPojo.class, key);
		List<DonViPojo> listnew = new ArrayList<>() ;
		for (DonViPojo donViPojo : list) {
			if(donViPojo.getTuoi().equals(tuoi))
			{
				listnew.add(donViPojo) ;
			}
		}
		JSONArray jsonarr =  JsonUtil.convertToJson(listnew) ;
		PrintWriter writer = resourceResponse.getWriter();
		System.out.println("chuoi" + jsonarr);
		 writer.write(jsonarr.toJSONString());
			System.out.println("ket qua " + tuoi);
		}
		
		
	}
	
	
}