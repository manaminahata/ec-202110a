package com.example.ecommerce_a.form;

/**
 * @author cyjoh
 *
 */
public class SearchItemByNameForm {

	private String searchingName;

	public String getSearchingName() {
		return searchingName;
	}

	public void setSearchingName(String searchingName) {
		this.searchingName = searchingName;
	}

	@Override
	public String toString() {
		return "SearchItemByNameForm [searchingName=" + searchingName + "]";
	}

}
