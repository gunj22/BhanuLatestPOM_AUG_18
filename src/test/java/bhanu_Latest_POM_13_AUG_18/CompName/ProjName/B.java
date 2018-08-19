package bhanu_Latest_POM_13_AUG_18.CompName.ProjName;

import org.testng.Assert;
import org.testng.annotations.Test;

public class B {

	int i = 1;

	@Test
	public void testingB() {

		if (i == 3) {
			Assert.assertTrue(true);
		} else {

			i++;
			Assert.assertTrue(false);
		}
	}

}
