package com.fptree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FPtree {
	
	public static void main(String[] args) {
		
		String file = "/home/aishwarya/1-umn/dm/projects/smallest";
		int tran_id, item;
		HashMap <Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		
			try {
				FileInputStream fr = new FileInputStream(file);
				InputStreamReader isr = new InputStreamReader(fr);
				BufferedReader br = new BufferedReader(isr);
				
				//BufferedReader br = new BufferedReader(fr);
				
				String curr_line;
				
				while((curr_line = br.readLine()) != null) {
					System.out.println(curr_line);
					
					String[] words = curr_line.split(" ");
					tran_id = Integer.parseInt(words[0]);
					item = Integer.parseInt(words[1]);
					System.out.println(tran_id);
					System.out.println(item);
					
					
					if(map.containsKey(tran_id))
						map.get(tran_id).add(item);
					
					else {
						ArrayList<Integer> itemset = new ArrayList<Integer>();
						itemset.add(item);
						map.put(tran_id, itemset);
					}
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		Set<Integer> keys = map.keySet();
		for(Iterator<Integer> i = keys.iterator(); i.hasNext(); ) {
			
			Integer key = i.next();
			System.out.println("value of key =" + key);
			ArrayList<Integer> itemset = map.get(key);
			int j = 0;
			System.out.println("Tran_id = " + key);
			System.out.println("Itemset = ");
			while(j < itemset.size()) {
				System.out.println(itemset.get(j));
				j++;
			}
				
			
		}
		
		
	}
	
	

}
