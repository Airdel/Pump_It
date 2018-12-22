/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import static javax.swing.JOptionPane.showMessageDialog;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author Marval
 */
public class sonidos {
    
    public void PumpItIntroSound()
    {
       try
        {
        ouf=new FileInputStream(new File("src\\sonidos\\bop_it\\VO_Miscellaneous_Bop It [Intro].wav"));
        AudioStream sonido=new AudioStream(ouf);
        AudioPlayer.player.start(sonido);
        }catch(Exception e)
        {
            showMessageDialog(null,e.getMessage());
        }
    }
        public void PumpItIntroFailSound()
    {
       try
        {
        ouf=new FileInputStream(new File("src\\sonidos\\bop_it\\VO_Die_04.wav"));
        AudioStream sonido=new AudioStream(ouf);
        AudioPlayer.player.start(sonido);  
        }catch(Exception e)
        {
            showMessageDialog(null,e.getMessage());
        }
    }
        public void PumpItGameRunSound()
    {
       try
        {
        ouf=new FileInputStream(new File("src\\sonidos\\bop_it\\VO_Bop.wav"));
        AudioStream sonido=new AudioStream(ouf);
        AudioPlayer.player.start(sonido);  
        }catch(Exception e)
        {
            showMessageDialog(null,e.getMessage());
        }
    }
        
        
        
        InputStream ouf,wii;
}
