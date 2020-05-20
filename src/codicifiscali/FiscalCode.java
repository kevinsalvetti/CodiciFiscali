package codicifiscali;

public class FiscalCode {

	private int id;
	private String name;
	private String surename;
	private String commune;
	private String data;
	

	/**
	 * Costruttore della classe
	 * 
	 * @param id
	 * @param name
	 * @param surename
	 * @param commune
	 * @param day
	 * @param month
	 * @param year
	 */
	public FiscalCode(int id, String name, String surename, String commune, String data) {
		super();
		this.id = id;
		this.name = name;
		this.surename = surename;
		this.commune = commune;
		this.data = data;
		
	}
	
	
	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurename() {
		return surename;
	}

	public void setSurename(String surename) {
		this.surename = surename;
	}

	public String getCommune() {
		return commune;
	}

	public void setCommune(String commune) {
		this.commune = commune;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}


	

	/**
	 * costruttore per creazione stringa codiceFiscale
	 * 
	 * @return
	 * @throws Exception
	 */
	@Override
	public String toString() {
		return "FiscalCode [id=" + id + ", name=" + name + ", surename=" + surename + ", commune=" + commune + ", data="
				+ data + "]";
	}
	
}
