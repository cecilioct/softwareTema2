/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareT2;

import java.util.ArrayList;

/**
 *
 * @author cecilio
 */
public class ctrlMetodos {
    
    public tblBiseccion Biseccion(double Li, double Ls,double errorDeseado, double iter){
        ArrayList<csBiseccion>lista=null;
        tblBiseccion tabla=null;
        
        double fxi;
        double fxs;
        double errorCalculado=1;
        int iteracion=0;
        double xAnterior; 
        
        fxi = this.getfx(Li);
        fxs = this.getfx(Ls);
        
        if((fxi*fxs)<0){
            
           lista=new ArrayList<csBiseccion>();
             
             while(errorCalculado>errorDeseado && iter>0){
                csBiseccion fila = new csBiseccion();
                fila.setIteracion(iteracion+1);
                fila.setXi(Li);
                fila.setXs(Ls);
                fila.setXr((fila.getXi()+fila.getXs())/2);
                fila.setFi(this.getfx(fila.getXi()));
                fila.setFr(this.getfx(fila.getXr()));
                fila.setProducto(fila.getFi()*fila.getFr());
                
                
                
                if(fila.getProducto()>0){
                    errorCalculado=this.errorRelativo(Li,Ls);
                    xAnterior=Li;
                    Li=fila.getXr();
                }else{
                   errorCalculado=this.errorRelativo(Li,Ls);
                    xAnterior=Ls;
                    Ls=fila.getXr();
                    
                }
               // errorCalculado =this.errorRelativo(fila.getXr(), xAnterior);
                fila.setError(errorCalculado);
                fila.toString();
                lista.add(fila);
                iteracion++;
             
             }
            tabla=new tblBiseccion(lista);
            return tabla;

        }else{
            return null;
        }
        
       
    }
    private double getfx(double x){
        
        return 0;
        
    }

    private double errorRelativo(double xActual, double xAnterior){
        return Math.abs((xActual-xAnterior)/xActual);
        
    }
    
  
    
}
