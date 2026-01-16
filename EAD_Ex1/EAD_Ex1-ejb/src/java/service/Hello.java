/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package service;

import jakarta.ejb.Stateless;
import jakarta.ejb.LocalBean;

/**
 *
 * @author DUADEPTRAI
 */
@Stateless
@LocalBean
public class Hello {

    public String say(String s){
        if (s==null){
            return null;
        }
        
        String trimmed = s.trim();
        String[] words = trimmed.split("\\s+");
        StringBuilder rs = new StringBuilder();
        for (String word: words){
            if(word.length() > 0){
                String normalizeWord = word.substring(0, 1).toUpperCase()
                                        +word.substring(1).toLowerCase();
                if (rs.length() > 0){
                    rs.append(" ");
                }
                rs.append(normalizeWord);
            }
        }
        return rs.toString();
    }
}
