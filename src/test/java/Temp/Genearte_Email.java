package Temp;

import java.util.Date;

public class Genearte_Email {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Date date = new Date();
		String dateString = date.toString();
		String noSpaceString = dateString.replace(" ", "");
		String noColonString = noSpaceString.replace(":", "");
		String addDomainString = noColonString + "gmail.com";
		System.out.println(addDomainString);
		
	}

}
