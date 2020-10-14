package prac1014;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.net.URL;
import java.util.*;

public class HashMapSetTest {

	public static void main(String[] args) {
		HashMap<String, String> phone = new HashMap<String, String>();
		
		phone.put("강수지", "010-1111-2222");
		phone.put("배수지", "010-3333-4444");
		phone.put("이효리", "010-6666-5555");
		
		SortedSet<String> keys = new TreeSet<>(phone.keySet());
		// ksy문자열을 가진 set리턴 
		Iterator<String> it = keys.iterator();
		while(it.hasNext()) {
			String key = it.next();
			String value = phone.get(key);
			System.out.println(key + " 전화번호: " + value);
		}
		
		Scanner scan = new Scanner(System.in);
		for(int i = 0; i < 3; i++) {
			System.out.print("찾고 싶은 사람의 번호? ");
			String name = scan.next();
			System.out.println(phone.get(name));
		}

	}

}


