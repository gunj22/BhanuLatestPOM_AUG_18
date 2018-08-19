package bhanu_Latest_POM_13_AUG_18.CompName.ProjName.helper.Logger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import bhanu_Latest_POM_13_AUG_18.CompName.ProjName.helper.Resource.ResourceHelper;

public class LoggerHelper {

	private static boolean root = false;

	public static Logger getLogger(Class cls) {
		if (root) {

			return Logger.getLogger(cls);

		}

		PropertyConfigurator
				.configure(ResourceHelper.getResourcePath("\\src\\main\\resources\\configFile\\log4j.properties"));
		root = true;
		return Logger.getLogger(cls);

	}

}
