/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package v2d;
import java.io.File;
import it.sauronsoftware.jave.*;

import java.io.IOException;

/**
 *
 * @author vaio
 */
 public class videotoaudio {

    /**
     *
     * @param video
     */
    public static void ConvertToAudio(File video) throws IOException{
        System.err.println("Start Converting.......");
        
        String s1=video.toString();
        int pos = s1.lastIndexOf("\\")+1;
         //System.out.println(pos);
        String n = s1.substring(pos);
        //System.out.println(n);
          
          String n1[]=n.split("\\.",2);
          //System.out.println(n1[0]);
          
          
          String name=n1[0].concat(".wav");
          //System.out.println(name);
          
          
          String s2 = s1.substring(0,pos); 
          //System.out.println(s2);
          
          String path=s2.concat(name);
          //System.out.println(path);
          
          
          
          
         
        
       
         
          
        
        
        File Audio=new File(path);
        AudioAttributes audio=new AudioAttributes();
        audio.setCodec("pcm_s24le");
        audio.setBitRate(new Integer(16000));
        audio.setChannels(new Integer(1));
        audio.setSamplingRate(new Integer(16000));
        EncodingAttributes attr=new EncodingAttributes();
        attr.setFormat("wav");
        attr.setAudioAttributes(audio);
        Encoder encode=new Encoder();
        try{
            encode.encode(video, Audio, attr);
            System.err.println("Convert Finished");
        }
        catch(Exception e){
            System.err.println(e.toString());
        }
        audiorecognizer.audiorecognizer.aRmain(path,s2,n1[0]);
        
    }
}
