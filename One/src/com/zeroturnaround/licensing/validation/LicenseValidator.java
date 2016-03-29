//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.zeroturnaround.licensing.validation;

import com.zeroturnaround.licensing.UserLicense;
import com.zeroturnaround.licensing.validation.JRebelLicenseValidator;
import com.zeroturnaround.licensing.validation.XRebelLicenseValidator;
import java.security.PublicKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import play.core.enhancers.PropertiesEnhancer.GeneratedAccessor;
import play.core.enhancers.PropertiesEnhancer.RewrittenAccessor;

@GeneratedAccessor
@RewrittenAccessor
public abstract class LicenseValidator {
	protected static final Logger log = LoggerFactory.getLogger(LicenseValidator.class);
	protected final UserLicense lic;
	protected final PublicKey pubKey;
	protected String invalidityErrorMessage;

	public LicenseValidator(UserLicense lic, PublicKey pubKey) {
		System.out.println("IGOR BOBKO FOREVER!!!!!!!!!!!!!!!!!!!");
		System.out.println("IGOR BOBKO FOREVER!!!!!!!!!!!!!!!!!!!");
		System.out.println("IGOR BOBKO FOREVER!!!!!!!!!!!!!!!!!!!");
		System.out.println("IGOR BOBKO FOREVER!!!!!!!!!!!!!!!!!!!");
		System.out.println("IGOR BOBKO FOREVER!!!!!!!!!!!!!!!!!!!");
		System.out.println("IGOR BOBKO FOREVER!!!!!!!!!!!!!!!!!!!");
		System.out.println("IGOR BOBKO FOREVER!!!!!!!!!!!!!!!!!!!");
		System.out.println("IGOR BOBKO FOREVER!!!!!!!!!!!!!!!!!!!");
		System.out.println("IGOR BOBKO FOREVER!!!!!!!!!!!!!!!!!!!");
		System.out.println("IGOR BOBKO FOREVER!!!!!!!!!!!!!!!!!!!");
		this.lic = lic;
		this.pubKey = pubKey;
	}

/*	public void validateSignature() {

	}*/

	public String getInvalidityErrorMessage() {
		return this.invalidityErrorMessage;
	}

	public abstract boolean isAllowed();

	public void validateSignature() {
		if(!this.lic.selfVerify(this.pubKey)) {
//			throw new SecurityException("Unable to load license. License verification failed.");
		}
	}

	public static boolean isEvaluation(UserLicense lic) {
		return true;
		//		String type = (String)lic.getData().get("Type");
//		if("evaluation".equals(type)) {
//			return true;
//		} else {
//			boolean isCommercial = Boolean.valueOf((String)lic.getData().get("commercial")).booleanValue();
//			boolean isLimited = lic.getData().containsKey("limited");
//			boolean isDedicated = "dedicated".equals(type);
//			boolean isXRebel = isXRebelProduct(lic);
//			return !isCommercial && !isLimited && !isDedicated && !isXRebel;
//		}
	}

	public static boolean isManaged(UserLicense lic) {
		return true;
		//		String type = (String)lic.getData().get("Type");
//		return "managed".equals(type);
	}

	public static boolean isDedicated(UserLicense lic) {
		return true;
//		String type = (String)lic.getData().get("Type");
//		return "dedicated".equals(type);
	}

	public static boolean isPerpetual(UserLicense lic) {
//		log.info("License:" + lic.getData());
//		boolean commercial = Boolean.valueOf((String)lic.getData().get("commercial")).booleanValue();
//		String product = (String)lic.getData().get("Product");
//		Object validFrom = lic.getData().get("validFrom");
//		Object validUntil = lic.getData().get("validFrom");
//		return commercial && validFrom == null && validUntil == null && product != null && product.contains("JavaRebel");
		return true;
	}

	public static LicenseValidator create(UserLicense lic) {
		return (LicenseValidator)(isXRebelProduct(lic)?new XRebelLicenseValidator(lic):new JRebelLicenseValidator(lic));
	}

	public static boolean isXRebelProduct(UserLicense lic) {
		String product = (String)lic.getData().get("Product");
		return product != null && product.equals("XRebel");
	}
}
