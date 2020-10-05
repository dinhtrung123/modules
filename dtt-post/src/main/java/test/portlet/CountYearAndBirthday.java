package test.portlet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import SystemConstant.SystemConstant;


public class CountYearAndBirthday {
	
	public static Map<Integer, Long> Count(){
	
		 String key = "/getSoBaiBaoGioGD" ;
		 List<DonVi> list = new ArrayList<>() ;
	
		List<DonViPojo> listModel = ModelUtil.getOject(SystemConstant.URL, DonViPojo.class, key);
	
	   for (DonViPojo donViPojo : listModel) {
			DonVi dv = new DonVi() ;
		 dv.setIdns(donViPojo.getIdns());
		 dv.setYear(Integer.parseInt(donViPojo.getYear()));
		 dv.setTuoi(Integer.parseInt(donViPojo.getTuoi()));
		 dv.setSobaibao(Integer.parseInt(donViPojo.getSobaibao()));
		 list.add(dv) ;
		   
	}		
	   Map<Integer,Long> counts = list.stream()
			     .collect(Collectors.groupingBy( DonVi::getYear , Collectors.summingLong(DonVi::getSobaibao)));
     

		 return counts ;
	}
	
	public static  Map<Age, Integer> CountBirthday(){
		String key = "/getSoBaiBaoGioGD" ;
		List<DonViPojo> listModel = ModelUtil.getOject(SystemConstant.URL, DonViPojo.class, key);
		List<DonVi>	list = new ArrayList<>() ;
		for (DonViPojo donViPojo : listModel) {
			DonVi dv = new DonVi() ;
			dv.setIdns(donViPojo.getIdns());
			dv.setSobaibao(Integer.parseInt(donViPojo.getSobaibao()));
			dv.setTuoi(Integer.parseInt(donViPojo.getTuoi()));
			dv.setYear(Integer.parseInt(donViPojo.getYear()));
			 list.add(dv) ;	    
		}	
		
		Function<DonVi, Age>  DonVi2Group = e -> {
			
			if(e.getTuoi() < 30 )
			{
				return Age.belowthirty ;
			} else if(e.getTuoi() >=30 && e.getTuoi() <40 )
			{
				return Age.thirtyFromforty;
			} else if(e.getTuoi() >=40 && e.getTuoi() <50)
			{
				return Age.fortyFromfifty;
			}else if(e.getTuoi() >=50 && e.getTuoi() < 60)
			{
				return Age.fiftyFromSixty ;
			}else
			{
				return Age.belowSixty ;
			}
			
		};
		
		Map<Age, Integer> counts = list.stream()
			    .collect(Collectors.groupingBy(DonVi2Group,Collectors.summingInt(DonVi:: getSobaibao)));   //<<<<<<
   
		return counts ;
	}
	

	
	
 
	

}
