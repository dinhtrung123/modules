package test.portlet;

public class DonVi {
     private Integer tuoi ;
     private Integer year ;
     private String idns;
     private Integer sobaibao;
     
     
	public DonVi() {
	
	}


	public Integer getTuoi() {
		return tuoi;
	}


	public void setTuoi(Integer tuoi) {
		this.tuoi = tuoi;
	}


	public Integer getYear() {
		return year;
	}


	public void setYear(Integer year) {
		this.year = year;
	}


	public String getIdns() {
		return idns;
	}


	public void setIdns(String idns) {
		this.idns = idns;
	}


	public Integer getSobaibao() {
		return sobaibao;
	}


	public void setSobaibao(Integer sobaibao) {
		this.sobaibao = sobaibao;
	}


	@Override
	public String toString() {
		return "DonVi [tuoi=" + tuoi + ", year=" + year + ", idns=" + idns + ", sobaibao=" + sobaibao + "]";
	}



     
}
