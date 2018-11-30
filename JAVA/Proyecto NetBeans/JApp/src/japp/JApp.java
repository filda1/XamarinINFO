
package japp;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class JApp {

    public static void main(String[] args) {
        
// Acomodar Suma total  de HH:mm:ss
          String date1 = "27:208:81";
          
                   String[] splitPart = date1.split(":");
                                
                   int hourNatural = Integer.parseInt(splitPart[0]);                                              
                   int minNatural = Integer.parseInt(splitPart[1]);	
                   int segNatural = Integer.parseInt(splitPart[2]);
                   
                   int segResultTotal= 0;
                   int minResultTotal = 0;
                   int hourResultTotal = 0;
                   int dayResultTotal = 0;
                   int dayReal = 0;
                   int minResult = 0;
                   int hourResult = 0;
                   int dayNatural = 0;
                   String Result;  
                   String ResultTotal;
                   
            
                    if (segNatural > 60){
                       int entero = (segNatural/60);  //================> verifica si solo da entero, sino hay que hacer split
                       int nEntero = entero * 60;
                       
                       segResultTotal = segNatural - nEntero;
                       minResult = minNatural + entero;
                       
                        if (minResult > 60){
                            int enteroDos = (minResult/60);  //================> verifica si solo da entero, sino hay que hacer split
                            int nEnteroDos = enteroDos * 60;
                            
                             minResultTotal = minResult - nEnteroDos;
                             hourResult = hourNatural + enteroDos  ;
                             
                              if (hourResult > 24){
                                   int enteroTres = (hourResult/24);  //================> verifica si solo da entero, sino hay que hacer split
                                   int nEnteroTres = enteroTres * 24;
                                   
                                    hourResultTotal = hourResult - nEnteroTres;
                                    dayResultTotal = dayNatural + enteroTres ;
                              }
                              else if (hourResult < 24){
                                  
                                    hourResultTotal = hourResult;
                                    dayResultTotal = 0 ;
                              }
                        }  
                        else if (minResult < 60){
                            
                             minResultTotal = minResult;
                                 hourResult = hourNatural;
                                 
                              if (hourResult > 24){
                                 
                                   int enteroCuatro = (hourResult/24);  //================> verifica si solo da entero, sino hay que hacer split
                                   int nEnteroCuatro = enteroCuatro * 24;
                                   
                                    hourResultTotal = hourResult - nEnteroCuatro;
                                    dayResultTotal = dayNatural + enteroCuatro ;
                              }
                              else if (hourResult < 24){
                                  
                                    hourResultTotal = hourResult;
                                    dayResultTotal = 0 ;
                              }
                        }
                    }
                    
                    
                      if (segNatural < 60){
                                       
                       segResultTotal = segNatural ;
                       minResult = minNatural;
                       
                        if (minResult > 60){
                            int enteroDos = (minResult/60);  //================> verifica si solo da entero, sino hay que hacer split
                            int nEnteroDos = enteroDos * 60;
                            
                             minResultTotal = minResult - nEnteroDos;
                             hourResult = hourNatural + enteroDos  ;
                             
                              if (hourResult > 24){
                                   int enteroTres = (hourResult/24);  //================> verifica si solo da entero, sino hay que hacer split
                                   int nEnteroTres = enteroTres * 24;
                                   
                                    hourResultTotal = hourResult - nEnteroTres;
                                    dayResultTotal = dayNatural + enteroTres ;
                              }
                              else if (hourResult < 24){
                                  
                                    hourResultTotal = hourResult;
                                    dayResultTotal = 0 ;
                              }
                        }  
                        else if (minResult < 60){
                            
                             minResultTotal = minResult;
                                 hourResult = hourNatural;
                                 
                              if (hourResult > 24){
                                 
                                   int enteroCuatro = (hourResult/24);  //================> verifica si solo da entero, sino hay que hacer split
                                   int nEnteroCuatro = enteroCuatro * 24;
                                   
                                    hourResultTotal = hourResult - nEnteroCuatro;
                                    dayResultTotal = dayNatural + enteroCuatro ;
                              }
                              else if (hourResult < 24){
                                  
                                    hourResultTotal = hourResult;   
                                    dayResultTotal = 0 ;                                  
                              }
                        }
                    }
                    
                      if (dayResultTotal == 0){
                         String h = String.valueOf(hourResultTotal);
                         String m = String.valueOf(minResultTotal);
                         String s = String.valueOf(segResultTotal);
                         
                         Result = h + " "+"horas"+ ","+ " " + m+ " " + "min"+","+ " " + s + " "+ "seg";                  
                      }
                      else {
                         String d = String.valueOf(dayResultTotal);
                         String h = String.valueOf(hourResultTotal);
                         String m = String.valueOf(minResultTotal);
                         String s = String.valueOf(segResultTotal);
                         
                         Result = d +" "+ "dias"+ "," + " " +  h + " " +"horas"+ ","+ " " + m+ " " + "min"+","+ " " + s + " "+ "seg";              
                      }
                      
                      ResultTotal = Result;
                      
                System.out.println("SUMA TOTAL" + ":" + " "+ ResultTotal);
        
// Restar Tiempo (HorasMinuSeg - HorasMinuSeg);                        
//*********************************************************** IDENTIFICAR TIEMPO MAYOR ***************************************************************                                   
                 /*  String date1 = "21-9-2017 02:37:40";
                   String date2 = "21-9-2017 06:23:56";
                   
                   String[] parts1 =date1.split(" ");
                   String parts11 = parts1[1];
                   String[] parts2 =date2.split(" ");
                   String parts21 = parts2[1];
                   
                   String[] parts12 = parts11.split(":");
                   String[] parts22 = parts21.split(":");
                                
                   int hMayor = Integer.parseInt(parts12[0]);                                              
                   int mMayor = Integer.parseInt(parts12[1]);	
                   int sMayor = Integer.parseInt(parts12[2]);	
                            
                   int hMenor = Integer.parseInt(parts22[0]);	
                   int mMenor = Integer.parseInt(parts22[1]);	
                   int sMenor = Integer.parseInt(parts22[2]);
                  
                   int hourMayor = 0;
                   int minMayor = 0 ;
                   int segMayor = 0 ;  
                   int hourMenor = 0;  
                   int minMenor = 0;
                   int segMenor = 0;
                                      
               
                   if ( hMayor < hMenor) {
                      hourMayor = hMenor;
                      minMayor = mMenor;
                      segMayor = sMenor;
                                         
                      hourMenor = hMayor;
                      minMenor = mMayor;
                      segMenor = sMayor;                                        
                    } 
                    else if ( hMayor > hMenor) {
                      hourMayor = hMayor;
                      minMayor = mMayor;
                      segMayor = sMayor;
                      
                      hourMenor = hMenor;
                      minMenor = mMenor;
                      segMenor = sMenor;
                    } 
                     else if ( hMayor == hMenor) {
                        if(mMayor > mMenor){
                              hourMayor = hMayor;  
                              minMayor = mMayor;
                              segMayor = sMayor;
                              
                              hourMenor = hMenor;
                              minMenor = mMenor;
                              segMenor = sMenor;
                        }  
                        if(mMayor < mMenor){
                              hourMayor = hMenor;  
                              minMayor = mMenor;
                              segMayor = sMenor;
                              
                              hourMenor = hMayor;
                              minMenor = mMayor;
                              segMenor = sMayor;
                        }

                        if(mMayor == mMenor){
                               if (sMayor > sMenor) {
                                 hourMayor = hMayor;  
                                 minMayor = mMayor;
                                 segMayor = sMayor;
                                 
                                 hourMenor = hMenor;
                                 minMenor = mMenor;
                                 segMenor = sMenor;
                               }
                                if (sMayor < sMenor) {
                                  hourMayor = hMenor;  
                                  minMayor = mMenor;
                                  segMayor = sMenor;
                              
                                  hourMenor = hMayor;
                                  minMenor = mMayor;
                                  segMenor = sMayor;
                               }
                                 if (sMayor == sMenor) {
                                 hourMayor = hMayor;  
                                 minMayor = mMayor;
                                 segMayor = sMayor;
                                 
                                 hourMenor = hMenor;
                                 minMenor = mMenor;
                                 segMenor = sMenor;
                            }
                        } 
                    }
                       
//****************************************************** SUMAR +60 A la DERECHA y RESTAR -1 A la IZQUIERDA *********************************************************************
                          int hourResult = 0;
                          int minResult = 0;
                          int segResult = 0;  
                          
                          int hourResult2 = 0;
                          int minResult2 = 0;
                          int segResult2 = 0;  
                          
                          int hourResultTotal = 0;
                          int minResultTotal = 0;
                          int segResultTotal = 0;  
                         
                         if (segMayor < segMenor){
                             segResult = (segMayor)+60;
                                segResultTotal = segResult - segMenor;
                                
                             minResult = (minMayor)-1;
                             hourResult = hourMayor;
                                
                                  if (minMayor < minMenor){
                                      
                                      minResult2 = minResult + 60;
                                         minResultTotal = minResult2 - minMenor;
                                       hourResult2 = hourResult -1;
                                        
                                       hourResultTotal = hourResult2 - hourMenor;
                                  }
                                  
                                     if (minMayor > minMenor){
                                      
                                      minResult2 = minResult ;
                                         minResultTotal = minResult2 - minMenor;
                                       hourResult2 = hourResult;
                                        
                                       hourResultTotal = hourResult2 - hourMenor;
                                  }                    
                         } 
                         
                              if (segMayor > segMenor){
                                  segResult = segMayor;
                                  segResultTotal = segResult - segMenor;
                                
                                  minResult = minMayor;
                                  hourResult = hourMayor;
                                 
                                  if (minMayor < minMenor){
                                      
                                      minResult2 = minResult + 60;
                                         minResultTotal = minResult2 - minMenor;
                                       hourResult2 = hourResult -1;
                                        
                                       hourResultTotal = hourResult2 - hourMenor;
                                  }
                                  
                                     if (minMayor > minMenor){
                                      
                                      minResult2 = minResult ;
                                         minResultTotal = minResult2 - minMenor;
                                       hourResult2 = hourResult;
                                        
                                       hourResultTotal = hourResult2 - hourMenor;
                                  }                     
                         } 
                         
                String subtractTime=  String.valueOf(hourResultTotal) + ":"  
                                +  String.valueOf(minResultTotal) + ":"   
                                +  String.valueOf(segResultTotal);
                
                
                          System.out.println(subtractTime);*/
                  
              
        }        
}
