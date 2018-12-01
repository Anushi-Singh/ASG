package audiorecognizer;

import java.lang.String;
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.api.StreamSpeechRecognizer;
import edu.cmu.sphinx.result.WordResult;
import java.io.FileInputStream;
import java.io.IOException;

import java.util.List;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class audiorecognizer {
    
    public static void aRmain(String wav,String s3 ,String y) throws IOException{
        
        String srt=s3.concat(y.concat(".srt"));
        File file = new File(srt);

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			    }

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
                        
                        //FileWriter fw = new FileWriter(file);
                 
			//BufferedWriter bw = new BufferedWriter(fw);
                        
                      
                       //BufferedWriter bw = new BufferedWriter((fw));  
  

                        PrintWriter pw = new PrintWriter(fw);
        int l=1;
        
      
        
        
        //System.out.println("Entered in Main");
/*        Configuration configuration = new Configuration();
 
// Set path to acoustic model.
configuration.setAcousticModelPath("resource:/WSJ_8gau_13dCep_16k_40mel_130Hz_6800Hz");
// Set path to dictionary.
configuration.setDictionaryPath("resource:/WSJ_8gau_13dCep_16k_40mel_130Hz_6800Hz/dict/cmudict.0.6d");
// Set language model.
configuration.setLanguageModelPath("models/language/en-us.lm.dmp");
*/



Configuration configuration = new Configuration();
  //System.out.println("Created configuration");
// Set path to acoustic model.
configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
// System.out.println("Set Acoustic Model Path");
// Set path to dictionary.
configuration.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
 //System.out.println("set DictionaryPath");
// Set language model.
configuration.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");
//System.out.println("set Language model Path");
        

StreamSpeechRecognizer recognizer;
        recognizer = new StreamSpeechRecognizer(configuration);
//System.out.println("Speech Recognizer");
        FileInputStream n=null;
        
        
        if(y.equals("test"))
        {
          n=new FileInputStream("J:\\Automatic Subtitles Generator\\src\\audiorecognizer\\test.wav");  
        }
        else{
            
      n=new FileInputStream(wav);
        }
//System.out.println("Speech Recognizer2");
recognizer.startRecognition(n);
//SpeechResult result = recognizer.getResult();
//System.out.println("Got Audio File");

SpeechResult result;
while ((result = recognizer.getResult()) != null) {
    //System.out.println("Speech Results");
    // String resultText = result.getBestFinalResultNoFiller();
    //System.out.println("Got Result "+result+" Thanks");
    System.out.println(result.getHypothesis());
    //System.out.println("List of Words");
    
    WordResult r=null;
    List<WordResult> sa=result.getWords();
    System.out.println(sa);
    
    String r1=sa.toString();
       

         String[] arr= r1.split(":",3);
         //System.out.println(arr[0]);
         //System.out.println("Arr");
         
         String[] arr1=(arr[0]).split(",",3);
         //System.out.println("Arr1");
         //char[] s1= new char[arr1[2].length()];  //????????
         char[] s1= new char[arr1[2].length()]; 
         //System.out.println("Arr2");
         
           int j=0;
           //System.out.println("Arr3");
         
           
         
         for(int i=2;i<(arr1[2]).length();i++)
         {  //System.out.print(arr1[2].charAt(i)); 
                 
                   s1[j]=(arr1[2].charAt(i));
                    j++;
         }
         String s=new String(s1).replaceAll("\\D+", "");
         
        int a=0;
          
         try{
             a=Integer.parseInt(s);
            
            }
         catch(NumberFormatException ex){ 
               
                      // handle your exception
            }
         
         
           System.out.print(a);
           
              
           // System.out.print(s1);   
           
           int hh=0,mm=0,ss=0,ms=0;
           ss=a/1000;
           ms=a%1000;
           mm=ss/60;
           ss=ss-mm*60;
           hh=mm/60;
           mm=mm-hh*60;
           
           
           
           
           
           
           
          
           
          
           
           
           

			//String content = "This is the content to write into file";
                        //bw.write(content);

			
                        
                        
                        
                       
                          
                        
			pw.print(l+"\n");
                        l++;
                        //bw.write("\n");
                        pw.print((String.format("%02d",hh))+":");
                        //bw.write(":");
                        pw.print((String.format("%02d",mm))+":");
                        //bw.write(":");
                        pw.print((String.format("%02d",ss))+",");
                        //bw.write(",");
                        pw.print(ms+" --> ");
                        //bw.write(" --> ");
                        
                        
			//bw.close();
                       // pw.close();
                        

			//System.out.println("Done");

		
           
           
           
           
           
           
           
            
            

            
           
             
         System.out.println();
             
         
         
         
          
            
             
         
         //String[] arr1=(arr[0]).split("[");
         
         
         //System.out.println(arr1[1]);
         

       /* for ( String ss : arr) {

           System.out.println(ss);
  } */ 
        
    
    
    //System.out.println("print");
    
    for (WordResult r2 : result.getWords())
    {
       //String r1=r.toString();
       

         //String[] arr= r1.split(",");

        // for ( String ss : arr) {

          // System.out.println(ss);
  //}  
        
    System.out.println(r2);
    
    r=r2;
       //System.out.println("Exited For loop of word result");
}
    //System.out.println(r);
    
    
         int z=0;
    String r3=r.toString();
    
    String[] arr2= r3.split(":",3);
    String[] arr3=arr2[1].split("]");
    char s2[]= new char[arr3[0].length()];
           
    
    for(int i=0;i<(arr3[0]).length();i++)
             
    {           s2[i]=(arr3[0].charAt(i)); 
                z++;
         
    }


         String t=new String(s2).replaceAll("\\D+", "");
         
        int b=0;
          
         try{
             b=Integer.parseInt(t);
            
            }
         catch(NumberFormatException ex){ 
               
                      // handle your exception
            }
         
         
           System.out.print(b);
           
              
           // System.out.print(s1);   
             
           int hh1=0,mm1=0,ss1=0,ms1=0;
           ss1=b/1000;
           ms1=b%1000;
           
            
           mm1=ss1/60;
           ss1=ss1-mm1*60;
           hh1=mm1/60;
           mm1=mm1-hh1*60;
           
           
          
           
           
           

			//String content = "This is the content to write into file";

			/*File file = new File("C:\\Users\\abc\\Desktop\\A.srt");

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			//BufferedWriter bw = new BufferedWriter(fw);
                        PrintWriter pw = new PrintWriter(fw);*/
                        
                        
                        
                       
                          
                  
			
                        //bw.write("\n");
                        pw.print((String.format("%02d",hh1))+":");
                        //bw.write(":");
                        pw.print((String.format("%02d",mm1))+":");
                        //bw.write(":");
                        pw.print((String.format("%02d",ss1))+",");
                        //bw.write(",");
                        pw.print(ms1+"\n");
                        //bw.write(" --> ");
                        
                        
			//bw.close();
                        
                        pw.print(result.getHypothesis()+".");
                        pw.print("\n\n");
                       
             
                        

			//System.out.println("Done");

		
    
    
    
    
    
   // r=(WordResult) result.getWords();
    //System.out.println(r);
    /*System.out.println("Best 3 hypothesis:");
            for (String s : result.getNbest(3))
                System.out.println(s);

            System.out.println("Lattice contains "
                    + result.getLattice().getNodes().size() + " nodes");
    //System.out.println(result.getWords());
    System.out.println("Got Hypothesis");*/
    
    //result.getLattice().dumpDot("lattice.dot", "lattice");
  

//System.out.println("Out of while loop");
//result.getLattice().dumpDot("lattice.dot", "lattice");
/* for (WordResult r : result.getWords()) {
    System.out.println("Entered For loop of word result");
    System.out.println(r);
    System.out.println("Exited For loop of word result");
}*/
}
recognizer.stopRecognition();
pw.flush();

 pw.close();
 String mp5=s3.concat(y.concat(".mp4"));
 File f=new File(mp5);
 java.awt.Desktop.getDesktop().open(f);
 
//System.out.println("Closed Recognizer");

//System.out.println(result.getHypothesis());

}
//result.getLattice().dumpDot("lattice.dot", "lattice");
//.toURI().toURL()
   

}

