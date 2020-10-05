package com.trung.portlet;

public class DonViPojo {
	 private String idns;

	    private String year;

	    private String hotenkhaisinh;

	    private String giogiangday;

	    private String tuoi;

	    private String sobaibao;

	    public String getIdns ()
	    {
	        return idns;
	    }

	    public void setIdns (String idns)
	    {
	        this.idns = idns;
	    }

	    public String getYear ()
	    {
	        return year;
	    }

	    public void setYear (String year)
	    {
	        this.year = year;
	    }

	    public String getHotenkhaisinh ()
	    {
	        return hotenkhaisinh;
	    }

	    public void setHotenkhaisinh (String hotenkhaisinh)
	    {
	        this.hotenkhaisinh = hotenkhaisinh;
	    }

	    public String getGiogiangday ()
	    {
	        return giogiangday;
	    }

	    public void setGiogiangday (String giogiangday)
	    {
	        this.giogiangday = giogiangday;
	    }

	    public String getTuoi ()
	    {
	        return tuoi;
	    }

	    public void setTuoi (String tuoi)
	    {
	        this.tuoi = tuoi;
	    }

	    public String getSobaibao ()
	    {
	        return sobaibao;
	    }

	    public void setSobaibao (String sobaibao)
	    {
	        this.sobaibao = sobaibao;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [idns = "+idns+", year = "+year+", hotenkhaisinh = "+hotenkhaisinh+", giogiangday = "+giogiangday+", tuoi = "+tuoi+", sobaibao = "+sobaibao+"]";
	    }
}
