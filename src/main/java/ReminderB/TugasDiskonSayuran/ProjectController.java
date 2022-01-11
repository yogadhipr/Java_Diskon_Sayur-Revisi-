/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReminderB.TugasDiskonSayuran;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 *
 * @author TUF GAMING
 */

@Controller
public class ProjectController {
    
    hitung h = new hitung();

    @RequestMapping("/input")
    public String getData(HttpServletRequest data, Model hasil)
    {
        
        String nSayur = data.getParameter("var_nama");
        String hSayur = data.getParameter("var_harga");
        String qSayur = data.getParameter("quantity");
        String uBayar = data.getParameter("var_bayar");
                
        Double harga = Double.valueOf(hSayur);
        Double jumlah = Double.valueOf(qSayur);
        Double bayar = Double.valueOf(uBayar);
        
        h.bayar(harga, jumlah);
        h.getKet(bayar, hasil);
        
        hasil.addAttribute("nama", nSayur);
        hasil.addAttribute("harga", hSayur);
        hasil.addAttribute("quantity", qSayur);
        hasil.addAttribute("uBayar", uBayar);
        hasil.addAttribute("hAwal", h.jBayar);
        hasil.addAttribute("diskon", h.disc);
        hasil.addAttribute("hDiskon", h.hDiskon);
        hasil.addAttribute("tBayar", h.tBayar);
                    
        return "view";
    }
}