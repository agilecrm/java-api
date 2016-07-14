package com.agilecrm.utils;

import java.util.Collection;
import java.util.Map;

/**
 * <code>StringUtils</code> class has method to check parameters whether there
 * are null or empty
 * 
 * @author Tejaswi
 * @since March 2013
 */
public class StringUtils
{

    /**
     * This method is used to check for the null or empty parameters in string
     * array
     * 
     * @param params
     *            {@link String} array of parameters to be checked.
     * @return {@link Boolean} value false if parameters not null and true if
     *         even one parameter is null or empty
     */

    public static boolean isNullOrEmpty(String[] params)
    {

	// Check for null and empty
	for (String item : params)
	{

	    if (item == null || item.equals("null")
		    || item.trim().length() == 0)
		return true;
	}
	return false;
    }

    /**
     * This method is used to check for the null or empty {@link Collection}
     * 
     * @param coll
     *            {@link Collection} to be checked.
     * @return {@link Boolean} value true if {@link Collection} is null or size
     *         is zero, else returns false
     */

    @SuppressWarnings("rawtypes")
    public static boolean isNullOrEmpty(Collection coll)
    {

	if (coll == null || coll.size() == 0)
	    return true;

	return false;
    }

    /**
     * This method is used to check for the null or empty {@link Map}
     * 
     * @param map
     *            {@link Map} to be checked.
     * @return {@link Boolean} value true if {@link Map} is null or size is
     *         zero, else returns false
     */

    @SuppressWarnings("rawtypes")
    public static boolean isNullOrEmpty(Map map)
    {

	if (map == null || map.size() == 0)
	    return true;

	return false;
    }

}
