package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 鍔熻兘绠�粙锛歁D5鍔犲瘑宸ュ叿绫� 瀵嗙爜绛夊畨鍏ㄤ俊鎭瓨鍏ユ暟鎹簱鏃讹紝杞崲鎴怣D5鍔犲瘑褰㈠紡
 * 
 * @author
 * 
 * 
 */
public class EnCriptUtil {
	// encriptType鍙互閫夌敤MD5鍜孲HA-1
	public static String getEcriptStr(String inStr, String encriptType) {
		String outStr = null;
		if (inStr == null) {
			outStr = null;
		} else if ("".equals(inStr)) {
			outStr = "";
		} else {
			try {
				MessageDigest md = MessageDigest.getInstance(encriptType);
				md.update(inStr.getBytes());
				byte b[] = md.digest();

				StringBuffer buf = new StringBuffer();
				for (int i = 0; i < b.length; i++) {
					int c = b[i] >>> 4 & 0xf;
					buf.append(Integer.toHexString(c));
					c = b[i] & 0xf;
					buf.append(Integer.toHexString(c));
				}
				outStr = buf.toString();
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return outStr;
	}

	// 123456 -> md5瀵嗘枃
	// 鐢ㄤ簬鐢熸垚瀵圭敤鎴峰瘑鐮佽繘琛宮d5鍔犲瘑鐨勫瓧绗︿覆缁撴瀯锛屼娇鐢ㄧ敤鎴峰悕+鍏抽敭瀛�瀵嗙爜
	public static String fix(String str1, String str2) {
		return str1 + "ac" + SystemParameter.key + "bd" + str2;
	}

	public static void main(String args[]) {
		// String str = "123456";
		// System.out.println(EnCriptUtil.getEcriptStr("TravelForumAdmin123456",
		// "MD5"));

		String str = fix("admin", "123456");
		System.out.println(str);
		String s = EnCriptUtil.getEcriptStr(str, "MD5");
		System.out.println(s);
		System.out.println(s.length());
		// 2c415067d31c71e2dd364ae173c78a
	}
}