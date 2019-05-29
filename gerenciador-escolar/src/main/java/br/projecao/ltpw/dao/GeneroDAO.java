/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.projecao.ltpw.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.projecao.ltpw.model.Genero;
import br.projecao.ltpw.util.HibernateUtil;

/**
 *
 * @author alberto torres
 */
public class GeneroDAO {
    
    private static GeneroDAO instancia;
    private GeneroDAO(){
    
    }
    
    public static synchronized GeneroDAO getInstance(){
        if (instancia == null) instancia = new GeneroDAO();
        return instancia;
    }
    
    
    

    private static Session sessionObj = HibernateUtil.getSessionFactory().openSession();
    
     //Adicionar um novo aluno na base de dados
    public List<Genero> obterTodosGeneros() { 
         List<Genero> lGeneros = null;
        try {

            lGeneros = sessionObj.createQuery("from Genero").list();
            System.out.print("++++++++++++++++++++++++++++++");
            
            if (lGeneros != null)
            System.out.print("Tamanho Generos" + lGeneros.size());

 
        } catch (Exception exceptionObj) {
            exceptionObj.printStackTrace();
        } 
        
        return lGeneros;
    }
    
    
       public Genero obterGeneroPorChave(Genero pGenero){
        Genero lGenero = null;
        sessionObj = HibernateUtil.getSessionFactory().openSession();
          try {
                Query query = sessionObj.createQuery ("from Genero where idGenero = " + pGenero.getIdGenero());
                lGenero = (Genero)query.uniqueResult();
                
               
            } catch (Exception e) {
                e.printStackTrace();
            }
            
          sessionObj.close();
              return lGenero;
        }
 
    
    
}
