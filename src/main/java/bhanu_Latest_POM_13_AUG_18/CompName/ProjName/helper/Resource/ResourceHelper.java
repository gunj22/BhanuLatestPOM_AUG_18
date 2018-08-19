package bhanu_Latest_POM_13_AUG_18.CompName.ProjName.helper.Resource;

import org.apache.log4j.Logger;

import bhanu_Latest_POM_13_AUG_18.CompName.ProjName.helper.Logger.LoggerHelper;

public class ResourceHelper {

	private static Logger log = LoggerHelper.getLogger(ResourceHelper.class);

	public static String getResourcePath(String path) {

		String commonPath = System.getProperty("user.dir");
		String completePath = commonPath + path;
		return completePath;
	}

}
