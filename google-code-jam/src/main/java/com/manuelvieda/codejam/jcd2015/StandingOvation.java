/**
 * Manuel Vieda - Copyright (c) 2015
 * http://manuelvieda.com
 * Date: 11/04/2015
 */
package com.manuelvieda.codejam.jcd2015;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

import com.manuelvieda.codejam.practice.OldMagician;

/**
 * <b>Problem A. Standing Ovation</b>
 * 
 * <p>It's opening night at the opera, and your friend is the prima donna (the lead female singer). You will
 * not be in the audience, but you want to make sure she receives a standing ovation -- with every audience 
 * member standing up and clapping their hands for her.
 * <p>Initially, the entire audience is seated. Everyone in the audience has a shyness level. An audience 
 * member with shyness level Si will wait until at least Si other audience members have already stood up to 
 * clap, and if so, she will immediately stand up and clap. If Si = 0, then the audience member will always 
 * stand up and clap immediately, regardless of what anyone else does. For example, an audience member with 
 * Si = 2 will be seated at the beginning, but will stand up to clap later after she sees at least two other 
 * people standing and clapping.
 * <p>You know the shyness level of everyone in the audience, and you are prepared to invite additional 
 * friends of the prima donna to be in the audience to ensure that everyone in the crowd stands up and claps
 * in the end. Each of these friends may have any shyness value that you wish, not necessarily the same. 
 * What is the minimum number of friends that you need to invite to guarantee a standing ovation?
 * 
 * @author Manuel E. Vieda
 * @version 1.0
 */
public class StandingOvation {
	
	
	/**
	 * The first line of the input gives the number of test cases, T. T test cases follow. Each consists 
	 * of one line with Smax, the maximum shyness level of the shyest person in the audience, followed by a
	 * string of Smax + 1 single digits. The kth digit of this string (counting starting from 0) represents
	 * how many people in the audience have shyness level k. For example, the string "409" would mean that
	 * there were four audience members with Si = 0 and nine audience members with Si = 2 (and none with 
	 * Si = 1 or any other value). Note that there will initially always be between 0 and 9 people with
	 * each shyness level.
	 * <p>The string will never end in a 0. Note that this implies that there will always be at least one 
	 * person in the audience.
	 */
	private static final String INPUT_FILE = "standing_ovation/A-large-practice.in";
	//private static final String INPUT_FILE = "standing_ovation/A-small-practice.in";
	
	/**
	 * For each test case, output one line containing "Case #x: y", where x is the test case number 
	 * (starting from 1) and y is the minimum number of friends you must invite.
	 */
	private static final String OUTPUT_FILE = "standing_ovation/A-large-practice.out";
	//private static final String OUTPUT_FILE = "standing_ovation/A-small-practice.out";
	
	/**
	 * Main Method
	 *
	 * @param args Program arguments
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(final String[] args) throws NumberFormatException, IOException {

		final File outputFile = new File(StandingOvation.class.getClassLoader().getResource(OUTPUT_FILE).getPath());

		try (
				final BufferedReader br = new BufferedReader(new InputStreamReader(
						OldMagician.class.getClassLoader().getResourceAsStream(INPUT_FILE),
						StandardCharsets.UTF_8));

				final OutputStreamWriter bw = new OutputStreamWriter(
						new FileOutputStream(outputFile),
						StandardCharsets.UTF_8)) {

			final int numberOfCases = Integer.valueOf(br.readLine());

			for (int i = 1; i <= numberOfCases; i++) {

				final String[] inputData = br.readLine().split(" ");
				
				int count = 0;
				int added = 0;
				int shyLevel=0;
				for (String shyGroup : inputData[1].split("")) {
					
					int shyness =  Integer.valueOf(shyGroup);
					if(shyness>0){
						int toAdd = shyLevel>count ? shyLevel-count : 0;
						added += toAdd;
						count += shyness+toAdd;
					}
					shyLevel++;
				}
				bw.write("Case #" + i + ": " +added + "\n");				
			}
		}
	}
}
