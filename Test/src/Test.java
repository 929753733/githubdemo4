import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.omg.CORBA.portable.ValueBase;

public class Test {
	
//	public static void main(String[] args) {
//		String a = "a&2\"dd";
//		System.out.println(a);
//		String b = "&|\"";
//		Pattern pattern = Pattern.compile(b);
//		Matcher matcher = pattern.matcher(a);
//		while(matcher.find()){
////			a = a.replaceAll("&", ";").replaceAll("z", "gg");
//            int count = matcher.groupCount() ; 
//            for (int i = 0; i <= count; i++) {
//                String ret = matcher.group(i) ; 
//                System.out.println(ret);
//            }
//        }
//	}
	
//	public static void main(String[] args) {
//		String characters = "&|>|<|\"|\'";
//		Pattern pattern = Pattern.compile(characters);
//		Map<String, Object> map = new HashMap<>();
//		map.put("aaa", "aaa&");
//		map.put("bbb", 2);
//		Set<String> set = map.keySet();
//		if(null!=set && !set.isEmpty()) {
//			for(String key : set) {
//				Object value = map.get(key);
//				if(value instanceof String) {
//					Matcher matcher = pattern.matcher((CharSequence) value);
//					while (matcher.find()) {
//						value = ((String) value).replaceAll("&", "&amp;").replaceAll(">", "&gt;")
//								.replaceAll("<", "&lt;").replaceAll("\"", "&quot;").replaceAll("\'", "&apos;");
//						map.put(key, value);
//					}
//				}
//			}
//		}
//		System.out.println(map.get("aaa"));
//	}
	
	public static void main(String[] args) {
		try {
			int aString = 333;
			System.out.println(aString);
			int a = 0;
			aString = a/0;
			System.out.println(aString);
		} catch (Exception e) {
		} finally {
			System.out.println("vvvvv");
		}
		
	}

}
