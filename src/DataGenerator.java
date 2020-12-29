import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class DataGenerator {

	static final String[] categories = {"a", "b", "c", "d", "n"};
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int cases = in.nextInt();
		
		String folder = in.next();
		new File(folder).mkdirs();
		
		for (int i = 0; i < cases; i++) {
			try {
				generateCase(i, folder);
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void generateCase(int i, String inputFolder) throws IOException {
		System.out.println("Generating test " + i + "...");
		BufferedWriter writer = new BufferedWriter(new FileWriter(inputFolder + "/test" + i + ".input"));
		
		Random r = new Random();
		
		int num = r.nextInt(500) + 2;
		
		writer.append("" + num);
		writer.newLine();
		
		for (int j = 0; j<num; j++) {
			for (int m = 0; m < 2; m++) {
				String out = "";
				ArrayList<String> remainingCategories = getListOfCategories();
				for (int k = 0; k < 4; k++) {
					String category = remainingCategories.remove(r.nextInt(remainingCategories.size()));
					if (category.equals("n")) {
						for (int l = k; l < 4; l++) {
							out+=category + " ";
						}
						break;
					} else {
						out+=category + " ";
					}
				}
				writer.append(out);
				writer.newLine();
			}
		}
		
		writer.close();
	}
	
	private static ArrayList<String> getListOfCategories() {
		ArrayList<String> out = new ArrayList<String>();
		for (String s : categories) {
			out.add(s);
		}
		return out;
	}

}
