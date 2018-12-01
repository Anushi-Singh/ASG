package v2d;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author vaio
 */
public class Main {
    public static void v2dmain(String v) throws IOException
    {
        File Video=new File(v);
        videotoaudio.ConvertToAudio(Video);
    }
}