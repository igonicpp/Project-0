/* This is a stub code. You can modify it as you wish. */
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;

class Main{
	
	public static void readAppFile(String file){
		Scanner scan;
    String str = "";
		try{
      BufferedReader br = new BufferedReader(new FileReader(file));

      while((str = br.readLine()) != null){
        String[] values = str.split(",");
        for(int i = 0; i < 7; i++){
          System.out.print(values[i] + ",");
        }
        System.out.println();
      }
    } catch(FileNotFoundException e){
      e.printStackTrace();
    } catch(IOException e){
      e.printStackTrace();
    }

      


			
			/*Complete the method*/
	}
	public static class Appliance {
		public String name;
		public int onW, offW; 
		public double probOn; 
		public boolean smart; 
		public double probSmart;

		public Appliance (String n, int on, int off, double pOn, boolean s, double pSmart)
		{ 
      name=n; onW=on; offW=off; probOn=pOn; smart=s; probSmart=pSmart; 
    }

		public String toString () {
			return name + "," + onW + "," + offW + "," + probOn + "," + smart + "," + probSmart;
		}
	}
	
	
	public static void main( String [] args ) throws IOException {
		Appliance [] app = new Appliance[100];  // default 100 possible appliance types
		File inputFile = new File( "ApplianceDetail.txt" );
		Scanner scan = new Scanner( inputFile );
		int count=0;
		while ( scan.hasNext( ) ) {
			StringTokenizer stringToken = new StringTokenizer(scan.nextLine());
			app[count] = new Appliance(stringToken.nextToken(","),
			Integer.parseInt(stringToken.nextToken(",")),
			Integer.parseInt(stringToken.nextToken(",")),
			Double.parseDouble(stringToken.nextToken(",")),
			Boolean.parseBoolean(stringToken.nextToken(",")),
			Double.parseDouble(stringToken.nextToken()));
			count++;
		}
/*
output a comma delimited file
the location (represented by an 8 digit numeric account number)
type (string)
"on" wattage used (integer)
probability (floating point, i.e..01=1%) that the appliance is "on" at any time
smart (boolean) 
Smart appliances (if "on") power reduction percent when changed to "low" status(floating point, i.e..33=33%).
*/
    int[] numAppliances = new int[100];
    
    int lWattage = 0;
		try
		{
      File file = new File("output.txt");
			FileWriter fw = new FileWriter( file , false);
			BufferedWriter bw = new BufferedWriter( fw );
      int uniqueID = 0;
			for (long location=1;location<=100 ;location++ ) {   // default 100 locations
				int applianceCount=(int)(Math.random()*6)+15;  //15-20 appliances per location 
        lWattage = 0;
        numAppliances[(int) location - 1] = applianceCount;
				for (int i=1;i<=applianceCount;i++ ){
					int index=(int)(Math.random()*count);  // pick an appliance randoml
          bw.write(String.valueOf(uniqueID));
          uniqueID++;
          bw.write( "," );
					bw.write(String.valueOf(10000000+location));
					bw.write( "," );		
					bw.write(app[index].name);
					bw.write( "," );		
					bw.write(String.valueOf(app[index].onW));
          lWattage += app[index].onW;
					bw.write( "," );									
					bw.write(String.valueOf(app[index].probOn));
					bw.write( "," );		
					bw.write(String.valueOf(app[index].smart));
					bw.write( "," );
					bw.write(String.valueOf(app[index].probSmart));
					bw.newLine( );
					bw.flush();
				}

			}

		int timeSteps;
    int wattage;
    String type;
    int onWat;
    double probOn;
    int location;
    boolean isSmart;
    double lowWat;

    
		//User interactive part
		Scanner sc = new Scanner(System.in);
    System.out.println("Enter number of timesteps: ");
    timeSteps = sc.nextInt();
    System.out.println("Enter maximum wattage for building: ");
    wattage = sc.nextInt();
    System.out.println("Enter the output csv file name: ");
    String fileName = sc.next();
    int[] tempWattage = new int[100];
    int totalAppliances = 0;
    //readAppFile("output.txt");
    for(int i = 0; i < numAppliances.length; i++){
      totalAppliances += numAppliances[i];
    }
    

    


      while(true){// Application menu to be displayed to the user.
        String option1 = "";
        System.out.println("Select an option:");
        System.out.println("Type \"A\" Add an appliance");
        System.out.println("Type \"D\" Delete an appliance");	
        System.out.println("Type \"L\" List the appliances");
        System.out.println("Type \"S\" To Start the simulation");
        System.out.println("Type \"Q\" Quit the program");
        option1=sc.next().toUpperCase();

        /* Complete the skeleton code below */
        if(option1.equals("A")){
          uniqueID = totalAppliances++;
          System.out.println("Enter the Appliance Name: ");
          type = sc.next();
          System.out.println("Enter the appliances wattage while on: ");
          wattage = sc.nextInt();
          System.out.println("Enter the appliances probability of being on: ");
          probOn = sc.nextDouble();
          System.out.println("Enter the appliances location(1-100): ");
          location = sc.nextInt();
          System.out.println("Is the appliance smart or regular(true for smart, false for regular): ");
          isSmart = sc.nextBoolean();
          System.out.println("Enter the appliance wattage reduction at the low state(0.0 for regular appliances): ");
          lowWat = sc.nextDouble();
          try{
            String str = "";
            boolean added = true;
            File tempFile = new File("Output.txt");
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            BufferedWriter bw1 = new BufferedWriter(new FileWriter(tempFile));
            while((str = br.readLine()) != null){
              String[] values = str.split(",");
              bw1.write(values[0]);
              bw1.write(",");
              bw1.write(values[1]);
              bw1.write(",");
              bw1.write(values[2]);
              bw1.write(",");
              bw1.write(values[3]);
              bw1.write(",");
              bw1.write(values[4]);
              bw1.write(",");
              bw1.write(values[5]);
              bw1.write(",");
              bw1.write(values[6]);
              bw1.newLine();
              bw1.flush();
              if(values[1].equals(String.valueOf(10000000 + location)) && added){
                bw1.write(String.valueOf(uniqueID));
                bw1.write(",");
                bw1.write(String.valueOf(10000000 + location));
                bw1.write(",");
                bw1.write(String.valueOf(type));
                bw1.write(",");
                bw1.write(String.valueOf(wattage));
                bw1.write(",");
                bw1.write(String.valueOf(probOn));
                bw1.write(",");
                bw1.write(String.valueOf(isSmart));
                bw1.write(",");
                bw1.write(String.valueOf(lowWat));
                bw1.newLine();
                bw1.flush();
                added = false;
                numAppliances[Integer.parseInt(values[1]) - 10000001]++;
              }
            }
            file.delete();
            tempFile.renameTo(file);

            


          } catch(IOException e){
            e.printStackTrace();
          }
            

          
        }
        else if(option1.equals("D")){
          System.out.println("Enter the unique ID of the appliance: ");
          String deleteApp = sc.next();
          try{
            String str = "";
            boolean deleted = true;
            File tempFile = new File("Output.txt");
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            BufferedWriter bw1 = new BufferedWriter(new FileWriter(tempFile));
            while((str = br.readLine()) != null){
              String[] values = str.split(",");
              if(values[0].equals(deleteApp)){
                deleted = false;
                numAppliances[Integer.parseInt(values[1]) - 10000001]--;
                totalAppliances--;
              }
              else{
                bw1.write(values[0]);
                bw1.write(",");
                bw1.write(values[1]);
                bw1.write(",");
                bw1.write(values[2]);
                bw1.write(",");
                bw1.write(values[3]);
                bw1.write(",");
                bw1.write(values[4]);
                bw1.write(",");
                bw1.write(values[5]);
                bw1.write(",");
                bw1.write(values[6]);
                bw1.newLine();
                bw1.flush();
              }
            }
            file.delete();
            tempFile.renameTo(file);

            


          } catch(IOException e){
            e.printStackTrace();
          }
        }
        else if(option1.equals("L")){
          readAppFile(fileName);
        }
        else if(option1.equals("F")){

        }
        else if(option1.equals("S")){
          int[] applianceAffected = new int[totalAppliances];
          boolean[] onAppliances = new boolean[totalAppliances];
          String str = "";
          int totalWattage = 0;
          int intParse;
          double doubleParse = 0.0;
          boolean booleanParse;
          int counter = 0;
          int lowWattage = 0;
          int numLowAppliances = 0;
          int numBrownOuts = 0;
          int finalTotalLocationsAffected = 0;
          int[] finalLocationsAffected = new int[100];
          int totalLocations = 0;
          

          for(int k = 0; k < timeSteps; k++)
          {
            int[] locationWattage = new int[100];
            int[] locationsAffected = new int[100];
            totalWattage = 0;
            str = "";
            counter = -1;
            int[] lowWattageLocation = new int[100];
            try{
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            double randNum = 0;
            // randomizes which appliances are on and off
            for(int i = 0; i < 100; i++){
              for(int j = 0; j < numAppliances[i]; j++){
                counter++;
                if((str = br.readLine()) != null){
                  String[] values = str.split(",");
                  doubleParse = Double.parseDouble(values[4]);
                  randNum = (((int) (Math.random() * 100)) * .01);
                  if(randNum < doubleParse){
                    onAppliances[counter] = true;
                    intParse = Integer.parseInt(values[3]);
                    totalWattage += intParse;
                    locationWattage[i] += intParse;
                  }
                  else{
                    onAppliances[counter] = false;
                  }
                }
              }
            }
            for(int i = 0; i < locationWattage.length; i++){
              lowWattageLocation[i] = locationWattage[i];
            }
            if(totalWattage > wattage){
              str = "";
              counter = 0;
              BufferedReader br2 = new BufferedReader(new FileReader(fileName));               
              int applianceCounter = 0;
              str = "";
              // turns smart appliances to low
              BufferedReader br1 = new BufferedReader(new FileReader(fileName));
              for(int i = 0; i < 100; i++){
                for(int j = 0; j < numAppliances[i]; j++){
                  lowWattage = 0;
                  if((str = br1.readLine()) != null){
                    String[] values2 = str.split(",");
                    booleanParse = Boolean.parseBoolean(values2[5]);
                    if(onAppliances[applianceCounter]){
                      if(booleanParse){
                        doubleParse = Double.parseDouble(values2[6]);
                        intParse = Integer.parseInt(values2[3]);
                        lowWattage += (int) (intParse * doubleParse);
                        totalWattage -= lowWattage;
                        numLowAppliances++;
                        lowWattageLocation[i] = lowWattageLocation[i] - lowWattage;
                        applianceAffected[applianceCounter]++;
                        applianceCounter++;
                      }
                      else{
                        applianceCounter++;
                      }
                    }
                    else{
                      applianceCounter++;
                    }
                  
                  }
                  if(totalWattage <= wattage){
                    break;
                  }
                
                }
                locationsAffected[i] = locationsAffected[i] + 1;
                counter = 0;
                if(totalWattage <= wattage){
                  break;
                }
              }
              if(totalWattage > wattage){
                int minWattage;
                int minIndex;
                for(int j = 0; j < lowWattageLocation.length; j++){  
                  minWattage = 1000000000;
                  minIndex = 0;
                  for(int i = 0; i < lowWattageLocation.length; i++){
                    if(lowWattageLocation[i] != 0){
                      if(lowWattageLocation[i] < minWattage){
                        minWattage = lowWattageLocation[i];
                        minIndex = i;
                      }
                    }

                  }
                  totalWattage -= lowWattageLocation[minIndex];
                  lowWattageLocation[minIndex] = 0;
                  numBrownOuts++;
                  locationsAffected[minIndex]++;
                  if(totalWattage <= wattage){
                    break;
                  }
                }
              }
              
            }
            else{
              System.out.println("Total wattage of building does not exceed allowed wattage.");
            }
            for(int l = 0; l < locationsAffected.length; l++){
              totalLocations += locationsAffected[l];
              finalLocationsAffected[l] += locationsAffected[l];
            }
            System.out.println("Number of smart appliances turned turned to low: " + numLowAppliances);
            numLowAppliances = 0;
            System.out.println("Number of brown outs: " + numBrownOuts);
            numBrownOuts = 0;
            System.out.println("Total number of locations affected for timestep " + k + ": " + totalLocations);
            System.out.println();
            finalTotalLocationsAffected += totalLocations;
            totalLocations = 0;
            } catch(FileNotFoundException e){
              e.printStackTrace();
            } catch(IOException e){
              e.printStackTrace();
            }
          }
          int maxLocation = 0;
          int maxLocationIndex = 0;
          for(int a = 0; a < finalLocationsAffected.length; a++){
            if(finalLocationsAffected[a] > maxLocation){
              maxLocation = finalLocationsAffected[a];
              maxLocationIndex = a;
            }
          }
          System.out.println("\n");
          System.out.println("Total number of locations affected after simulation: " + finalTotalLocationsAffected);
          if(maxLocationIndex > 0){
            System.out.println("Most affected location: " + (maxLocationIndex + 1));
          }
          else{
            System.out.println("No Location Affected");
          }
          File report = new File("FINAL_REPORT.txt");
          String output = "";
          BufferedWriter bw0 = new BufferedWriter(new FileWriter(report));
          BufferedReader br0 = new BufferedReader(new FileReader("output.txt"))
          ;
          int counter0 = 0;
          while((output = br0.readLine()) != null){
            String[] values = output.split(",");
            bw0.write("Appliance " + values[0] + ": " + applianceAffected[counter0]);
            bw0.newLine();
            bw0.flush();
            counter0++;
          } 
          for(int i = 0; i < finalLocationsAffected.length; i++){
            bw0.write("Location " + (i + 1) + "  affected: " + finalLocationsAffected[i] + " times");
            bw0.newLine();
            bw0.flush();
          }
          break;
        }
        else if(option1.equals("Q")){
          break;
        }
        else{
          System.out.println("Invalid choice");
        }
      }
		}
		catch( IOException ioe )
		{
			ioe.printStackTrace( );
		}
	}
}