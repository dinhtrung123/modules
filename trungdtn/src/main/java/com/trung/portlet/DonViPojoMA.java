package com.trung.portlet;

public class DonViPojoMA {
	private String idns;

    private String nambaibao;

    private String sotrichdan;

    private String year;

    private String hotenkhaisinh;

    private String tenbaibao;

    private String giogiangday;

    private String tuoi;

    private String tentapchi;

    private String sobaibao;

    public String getIdns ()
    {
        return idns;
    }

    public void setIdns (String idns)
    {
        this.idns = idns;
    }

    public String getNambaibao ()
    {
        return nambaibao;
    }

    public void setNambaibao (String nambaibao)
    {
        this.nambaibao = nambaibao;
    }

    public String getSotrichdan ()
    {
        return sotrichdan;
    }

    public void setSotrichdan (String sotrichdan)
    {
        this.sotrichdan = sotrichdan;
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

    public String getTenbaibao ()
    {
        return tenbaibao;
    }

    public void setTenbaibao (String tenbaibao)
    {
        this.tenbaibao = tenbaibao;
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

    public String getTentapchi ()
    {
        return tentapchi;
    }

    public void setTentapchi (String tentapchi)
    {
        this.tentapchi = tentapchi;
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
        return "ClassPojo [idns = "+idns+", nambaibao = "+nambaibao+", sotrichdan = "+sotrichdan+", year = "+year+", hotenkhaisinh = "+hotenkhaisinh+", tenbaibao = "+tenbaibao+", giogiangday = "+giogiangday+", tuoi = "+tuoi+", tentapchi = "+tentapchi+", sobaibao = "+sobaibao+"]";
    }
}
