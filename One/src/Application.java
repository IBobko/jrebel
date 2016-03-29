
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.spec.X509EncodedKeySpec;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import com.zeroturnaround.licensing.LicenseFileException;
import com.zeroturnaround.licensing.LicenseServer2ToJRebelPrivateKey;
import com.zeroturnaround.licensing.UserLicense;

import play.core.server.NettyServer;


public class Application
{
	public static void main(String[] args) throws IOException, LicenseFileException, ClassNotFoundException
	{

		//ObjectInputStream file = new ObjectInputStream(new FileInputStream("/home/igor/hybris/jrebel/jrebel.lic"));
		//UserLicense license1 = (UserLicense)file.readObject();
		//Map map = license1.getData();

//		for (Object obj: map.entrySet()) {
//			Map.Entry<String,Object> entry = (Map.Entry<String, Object>) obj;
//
//			System.out.println(entry.getKey() + " " + entry.getValue() + " " + entry.getValue().getClass());
//		}



		NettyServer.main(args);

		UserLicense license = new UserLicense();

		ByteArrayOutputStream outStream = new ByteArrayOutputStream();

		java.io.ObjectOutputStream s = new java.io.ObjectOutputStream(outStream);


		//ByteArrayInputStream stream = new ByteArrayInputStream(12);

		HashMap<String,Object> data = new HashMap<String, Object>();



		data.put("Type","floating");



//
//		data.put("OrderId","NEVER");
//
//		data.put("Comment","== Cracked by Igor Bobko, since 2015 ==");
//
//		data.put("Organization","todo100");
//
//		data.put("enterprise","true");
//
//		data.put("Name","Igor Bobko");
//


		Calendar calendar = new GregorianCalendar();
		calendar.set(Calendar.YEAR,2014);

		data.put("limited",calendar.getTime());
//
//		data.put("Email","limit-speed@yandex.ru");
//
//		data.put("override","true");
//
//		data.put("noBanner","true");
//
//		data.put("commercial","true");
//
//		data.put("digest",null);


		data.put("enterprise","true");

		data.put("commercial","true");


		data.put("evaluation","false");

		data.put("managed","true");
		data.put("dedicated","true");
		data.put("override","evaluation");
		data.put("Product","evaluation");
		data.put("validFrom",calendar.getTime());
		data.put("validUntil","evaluation");

		data.put("Name","evaluation");
		data.put("Email","limit-speed@yandex.ru");
		/**
		 * Уникальный идентификатор, обязательно должен быть строкой.
		 */
		data.put("uid",System.currentTimeMillis() + "");
		data.put("Organization","TODO100");
		data.put("Seats","500");
		data.put("limitedUntil","evaluation");
		data.put("limitedFrom","evaluation");
		data.put("validDays",600);
		data.put("OrderId","evaluation");
		data.put("ZeroId", "evaluation");





		s.writeObject(data);


		byte[] sig = LicenseServer2ToJRebelPrivateKey.generateSignature(outStream.toByteArray());
		license.setSignature(sig);

		//stream.read(lic);
		license.setLicense(outStream.toByteArray());

		license.writeToDisk(new File("C:\\Users\\User\\Desktop\\License\\license.lic"));

//		InputStream stream = Application.class.getClassLoader().getResourceAsStream("jrebel.lic");
//
//		byte[] lic = new byte[stream.available()];
//		stream.read(lic);
//		UserLicense license = UserLicense.loadInstance(lic);
//		Map data = license.getData();
//
//
//




	}
}
