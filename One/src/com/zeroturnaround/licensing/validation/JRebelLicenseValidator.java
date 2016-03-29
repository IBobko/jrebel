//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.zeroturnaround.licensing.validation;

import com.zeroturnaround.licensing.JRebelPublicKey;
import com.zeroturnaround.licensing.UserLicense;
import com.zeroturnaround.licensing.validation.LicenseValidator;
import play.core.enhancers.PropertiesEnhancer.GeneratedAccessor;
import play.core.enhancers.PropertiesEnhancer.RewrittenAccessor;

@GeneratedAccessor
@RewrittenAccessor
public class JRebelLicenseValidator extends LicenseValidator {
	public JRebelLicenseValidator(UserLicense lic) {
		super(lic, JRebelPublicKey.getPublicKey());
	}

	public boolean isAllowed() {
		return true;
	}

	public static boolean isEnterprise(UserLicense lic) {
		return true;
//		boolean commercial = Boolean.valueOf((String)lic.getData().get("commercial")).booleanValue();
//		boolean enterprise = Boolean.valueOf((String)lic.getData().get("enterprise")).booleanValue();
//		return commercial && !lic.getData().containsKey("limited") || enterprise;
	}
}
