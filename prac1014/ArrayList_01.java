package prac1014;

import java.util.*;

public class ArrayList_01 {

	public static void main(String[] args) {
		ArrayList<String> a1 = new ArrayList<>();
		add(a1);
		name(a1);
		System.out.println("================");
		name(a1);
		
		
		System.out.println(" ===================");
		
		LinkedList<String> kk = new LinkedList<>();
		String[] animal = {"ªÍ≈‰≥¢", "¡˝≈‰≥¢", "∆«≈‰≥¢", "¡◊¿∫≈‰≥¢", "æÀƒÆ∏Æ≈‰≥¢"};
		
		for(int i = 0; i < animal.length; i++) {
			kk.add(animal[i]);
		}
		Iterator<String> it2 = kk.iterator();
		while(it2.hasNext()) {
			//¥Ÿ¿Ω ø‰º“ ∏Æ≈œ
			System.out.println(it2.next());
		}
		
		System.out.println(a1);
		System.out.println(kk);
	}
	
	//a1æ»ø° ¿Ã∏ßµÈ √ﬂ∞°
	public static void add(ArrayList<String> a1) {
		String[] label = {"±∏∑∑¿Ã", "∆»∑∑¿Ã", "ƒ•∑∑¿Ã", "±∏∑∑¿Ã", "±∏∑∑ªÔ","±∏∑∑ªÁ"};
		for(int i = 0; i < label.length; i++) {
			a1.add(label[i]);
		}
	}
	
	// a1æ»ø°¿÷¥¬ ¿Ã∏ßµÈ √‚∑¬
	public static void name(ArrayList<String> a1) {
		for(int i = 0; i < a1.size(); i++) {
			System.out.println(a1.get(i));
		}
	}

}
