package pageUI.wordpress;

public class AbstractPageUI {

	public static final String POST_MENU = "//a[contains(@class, 'menu-icon-post')]";
	public static final String MEDIA_MENU = "//a[contains(@class, 'menu-icon-media')]";
	public static final String PAGES_MENU = "//a[contains(@class, 'menu-icon-link')]";
	
	public static final String DYNAMIC_PAGE = "//a[contains(@class, 'menu-icon-%s')]";
	public static final String UPLOAD_FILE_TYPE = "//input[starts-with(@id, 'html5')]";
	public static final String MEDIA_PROGRESS_BAR = "//div[@class='thumbnail']/div[@class='media-progress-bar']";
	public static final String ALL_LOADED_IMG = "//div[@class='thumbnail']//img";
}
