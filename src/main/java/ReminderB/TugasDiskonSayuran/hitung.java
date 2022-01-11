/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReminderB.TugasDiskonSayuran;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
/**
 *
 * @author TUF GAMING
 */

@Controller
class hitung {
    Double tBayar, jBayar, hDiskon;
    public int disc;
    public Double bayar(Double hSayur, Double quantity)
    {
        jBayar = hSayur * quantity;
        
        if(jBayar < 16000)
        {
            disc = 0;
        }
        else if(jBayar >= 16000 && jBayar < 25000)
        {
            disc = 10;
        }
        else
        {
            disc = 15;   
        }
        
        hDiskon = jBayar * disc/100;
        tBayar = jBayar - hDiskon;
        
        return tBayar;
    }
    
    public String getKet(Double uBayar, Model akhir){
       String keterangan = "";
       Double kembalian = uBayar - tBayar;
       Double kurang = tBayar - uBayar;
        
        if(tBayar < uBayar)
        {
            keterangan = "Kembalian anda Rp " + kembalian;
        }  
        else if (tBayar > uBayar)
        {
            keterangan = "Uang anda kurang Rp " + kurang;
        }
        else
        {
            keterangan = "Uang anda PAS!";
        }
        
        akhir.addAttribute("ket", keterangan);
        return keterangan;
    }
}
