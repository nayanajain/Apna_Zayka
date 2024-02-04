package com.project.RestaurentsHere.config;

import java.util.HashMap;

public class ShoppingConfiguration {
	
	public static  Boolean validationWithHashMap(String keys[], HashMap<String, String> request)
	{
		Boolean status=false;
		try
		{
			for(int start=0; start<keys.length; start++)
			{
				if(request.containsKey(keys[start]))
				{
					if(request.get(keys[start]).equals(""))
						throw new Exception(keys[start]+"should not be empty");
					
				}
				else
				{
					throw new Exception(keys[start]+"is missing");
					
				}
			}
			
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return status;
	}

}
