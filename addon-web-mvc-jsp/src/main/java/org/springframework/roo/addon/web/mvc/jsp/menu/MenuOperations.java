package org.springframework.roo.addon.web.mvc.jsp.menu;

import java.util.List;

import org.springframework.roo.model.JavaSymbolName;

/**
 * Interface to {@link MenuOperations}.
 * 
 * @author Stefan Schmidt
 * @author Ben Alex
 * @since 1.1
 *
 */
public interface MenuOperations {

	public static final String DEFAULT_MENU_ITEM_PREFIX = "i:";
	public static final String FINDER_MENU_ITEM_PREFIX = "fi:";

	/**
	 * Allows for the addition of menu categories and menu items. If a category or menu item with the
	 * given identifier exists then it will <b>not</b> be overwritten or replaced.
	 * <p>
	 * Addons can determine their own category and menu item identifiers so that there are no clashes 
	 * with other addons. 
	 * <p>
	 * The recommended category identifier naming convention is <i>addon-name_intention_category</i> where 
	 * intention represents a further identifier to diffentiate between different categories provided
	 * by the same addon. Similarly, the recommended menu item identifier naming convention is
	 * <i>addon-name_intention_menu_item</i>.
	 *  
	 * 
	 * @param menuCategoryName the identifier for the menu category (required)
	 * @param menuItemName the menu item identifier (required)
	 * @param globalMessageCode message code for the menu item (required)
	 * @param link the menu item link (required)
	 * @param idPrefix the prefix to be used for this menu item (optional, MenuOperations.DEFAULT_MENU_ITEM_PREFIX is default)
	 */
	void addMenuItem(JavaSymbolName menuCategoryName, JavaSymbolName menuItemName, String globalMessageCode, String link, String idPrefix);

	/**
	 * Attempts to locate a unused finder menu items and remove them. 
	 * 
	 * @param menuCategoryName the identifier for the menu category (required)
	 * @param allowedFinderMenuIds Finder menu ids currently installed
	 */
	void cleanUpFinderMenuItems(JavaSymbolName menuCategoryName, List<String> allowedFinderMenuIds);

	/**
	 * Attempts to locate a menu item and remove it. 
	 * 
	 * @param menuCategoryName the identifier for the menu category (required)
	 * @param menuItemName the menu item identifier (required)
	 * @param idPrefix the prefix to be used for this menu item (optional, MenuOperations.DEFAULT_MENU_ITEM_PREFIX is default)
	 */
	void cleanUpMenuItem(JavaSymbolName menuCategoryName, JavaSymbolName menuItemName, String idPrefix);

}