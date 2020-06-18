package pageUI.jQuery;

public class DataTablePageUI {

	public static final String DYNAMIC_HEADER_COLUMN_TEXT = "//div[@class='qgrd-header-text' and text()='%s']/parent::div/following-sibling::input";
	public static final String DYNAMIC_ONLY_ONE_ROW_WITH_TEXT = "//tr[not(@style='display: none;')]/td[text()='%s']";
	public static final String DYNAMIC_ICON_BY_COUNTRY = "//td[text()='%s']/preceding-sibling::td[@class='qgrd-actions']/button[contains(@class,'%s')]";
	public static final String DYNAMIC_PAGE_BY_INDEX = "//a[@class='qgrd-pagination-page-link' and text()='%s']";
	public static final String DYNAMIC_PAGE_ACTIVED_BY_INDEX = "//a[@class='qgrd-pagination-page-link active' and text()='%s']";
	public static final String DYNAMIC_COLUMN_POSITION_INDEX = "//th[text()='%s']/preceding-sibling::th";
	public static final String DYNAMIC_TEXTBOX_BY_ROW_AND_COLUMN = "//tr[%s]/td[%s]/input";
}
