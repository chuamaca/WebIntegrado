/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.*;
public class prueba1 {

    public static void main(String[] args) {
        Negocio obj=new Negocio();
        for(Detalle a:obj.LisDeta("F0002"))
            System.out.println(a.getNoma());
        
    }
    
}
