package JavaProject;

import java.io.*;
import java.util.*;

public class GUIScoreIO {
	HashMap <String, Float> usrresult = new HashMap<String, Float>(); //점수 저장 Hash Map;
	
	String levels;
	
	public GUIScoreIO(int level) {
		this.usrresult = fileRead();
		if (level == 1) {levels = "beginner";}
		else if (level == 2) {levels = "Intermediate";}
		else if (level == 3) {levels = "Advanced";}
	}
	
	public LinkedHashMap<String,Float> sortHash (HashMap<String,Float> hm){
		LinkedHashMap <String, Float> sortHash = new LinkedHashMap<String,Float>();
		
		String[] names = new String[hm.size()];
		float[] scores = new float[hm.size()];

		Iterator <String> keyhm = hm.keySet().iterator();
		
		//Input score data in names & scores array for sorting
		for (int k = 0; k < hm.size(); k++)
		{
			String keycard = keyhm.next();
			names[k] = keycard;
			scores[k] = hm.get(keycard);
		}
		
		//bubble sort
		for (int i = 0; i < hm.size(); i++) {
			for (int k = 0; k < hm.size()-i-1; k++) {
				if (scores[k] > scores[k+1]) {
					float buf = scores[k];
					scores[k] = scores[k+1];
					scores[k+1] = buf;
					String strbuf = names[k];
					names[k] = names[k+1];
					names[k+1] = strbuf;
				}
			}
		}
		
		for (int i = 0; i < hm.size(); i++) {
			sortHash.put(names[i], scores[i]);
		}	
		
		return sortHash;
	}
	
	public HashMap<String, Float> fileRead(){	
		HashMap<String,Float> usrlist = new HashMap<String,Float>();
		try {
			File f = new File("./score_"+levels+".txt");
			if (!(f.isFile())) {
				FileWriter fw = new FileWriter("./score_"+levels+".txt");			
			}
			FileReader fread = new FileReader(f);
			BufferedReader bufReader = new BufferedReader(fread);
			String line = "";
			while ((line = bufReader.readLine()) != null ) {
				String sco[] = line.split(" ");
				usrlist.put(sco[0], Float.parseFloat(sco[1]));
			}
		}
		catch(FileNotFoundException e) {System.out.println(e);}
		catch(IOException e) {System.out.println(e);}
		
		return usrlist;
	}
	
	public void saveScore(HashMap<String, Float> scolist, String usrname, Float score) {
		LinkedHashMap<String, Float> sorting = new LinkedHashMap<String, Float>();
		HashMap<String,Float> savlist = new HashMap<String,Float>(fileRead());
		savlist.put(usrname,score);
		sorting = sortHash(savlist);
		Iterator <String> nameset = sorting.keySet().iterator();
		try {
			File file = new File("./score.txt");
			BufferedWriter output = new BufferedWriter(new FileWriter("./score_"+levels+".txt"));
			int nums = 0;
			while (nameset.hasNext() && nums < 3) {
			String sv = new String();
			String keyname = nameset.next();
			
			sv = keyname + " " + Float.toString(sorting.get(keyname));
			
			output.write(sv);
			output.newLine();
			nums++;
			}
			output.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
