package bhanu_Latest_POM_13_AUG_18.CompName.ProjName.helper.Assertion;

import org.apache.log4j.Logger;
import org.testng.Assert;

import bhanu_Latest_POM_13_AUG_18.CompName.ProjName.helper.Logger.LoggerHelper;

public class AssertionHelper {

	private static Logger log = LoggerHelper.getLogger(AssertionHelper.class);

	public static void verifyText(String s1, String s2) {
		log.info("Verifying text : " + s1 + "with " + s2);
		Assert.assertEquals(s1, s2);
	}

	public static void makeTrue() {
		log.info("Making script pass ..");
		Assert.assertTrue(true);
	}

	public static void makeTrue(String message) {
		log.info("Making script pass .." + message);
		Assert.assertTrue(true, message);
	}

	public static void makeFalse() {
		log.info("Making script fail ..");
		Assert.assertTrue(false);
	}

	public static void makeFalse(String message) {
		log.info("Making script fail .." + message);
		Assert.assertTrue(false, message);
	}

	public static void verifyTrue(boolean status) {
		Assert.assertTrue(status);
	}

	public static void verifyFalse(boolean status) {
		Assert.assertFalse(status);
	}

	public static void verifyNullObject(String s1) {
		log.info("Verify Object is NULL");
		Assert.assertNull(s1);

	}

	public static void verifyNotNull(String s1) {
		log.info("Verify Object is not NULL");
		Assert.assertNotNull(s1);
	}

}
