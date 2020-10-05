package test.portlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import SystemConstant.SystemConstant;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=dtt-post Portlet",
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
		List<DonViPojo> listModel = ModelUtil.getOject(SystemConstant.URL, DonViPojo.class, key);
		for (DonViPojo donViPojo : listModel) {
			String check=donViPojo.getIdns().replaceAll("\\s", "");
			  donViPojo.setIdns(check);
		}
   	    renderRequest.setAttribute("list",listModel);
       
   	    Map<Age, Integer> map = CountYearAndBirthday.CountBirthday() ;
     	
   	     renderRequest.setAttribute("listnew", map);
   	
  	    Integer belowthirty =   CountYearAndBirthday.CountBirthday().get(Age.belowthirty) ;
   	    renderRequest.setAttribute("belowthirty",belowthirty);
   	    
   	    Integer thirtyFromforty =   CountYearAndBirthday.CountBirthday().get(Age.thirtyFromforty) ;
	    renderRequest.setAttribute("thirtyFromforty",thirtyFromforty);
	    
	    Integer fortyFromfifty =   CountYearAndBirthday.CountBirthday().get(Age.fortyFromfifty) ;
   	    renderRequest.setAttribute("fortyFromfifty",fortyFromfifty);
   	    
   	    Integer fiftyFromSixty =   CountYearAndBirthday.CountBirthday().get(Age.fiftyFromSixty) ;
   	    renderRequest.setAttribute("fiftyFromSixty",belowthirty) ;
     	 Integer belowSixty =   CountYearAndBirthday.CountBirthday().get(Age.belowSixty) ;
	    renderRequest.setAttribute("belowSixty",belowthirty);
	    
   	 /*
		 List<String> listAll = Arrays.asList("CO2", "CH4", "SO2", "CO2", "CH4", "SO2", "CO2", "CH4", "SO2","N01","N02");

		// Create a list with the distinct elements using stream.
		List<String> listDistinct = listAll.stream().distinct().collect(Collectors.toList());

		// Display them to terminal using stream::collect with a build in Collector.
		String collectAll = listAll.stream().collect(Collectors.joining(", "));
		System.out.println(collectAll); //=> CO2, CH4, SO2, CO2, CH4 etc..
		String collectDistinct = listDistinct.stream().collect(Collectors.joining(", "));
		System.out.println(collectDistinct); //=> CO2, CH4, SO2

		Map<String, Long> counts =
	                             	listAll.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
		System.out.println(counts);
		*/
   	    super.doView(renderRequest, renderResponse);
     	
    
    }
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		 String idns = ParamUtil.getString(resourceRequest, "idns") ;
		 String key =  "/getBaiBaoByMaCB?maCanBo="+idns+"" ; 
		JSONArray jsonarr =  ModelUtil.getOjectMA(SystemConstant.URL,DonViPojoMA.class, key, idns);
		PrintWriter writer = resourceResponse.getWriter();
		 writer.write(jsonarr.toJSONString());
		//super.serveResource(resourceRequest, resourceResponse);
		 
		 
		 
		 
		 
		 
		 
		
	}
	

	
	
	
	
	
}