/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videoclubjpa;

import javax.persistence.Persistence;
import javax.swing.JFrame;
import videoclubjpa.controllers.PeliculasJpaController;
import videoclubjpa.entities.Peliculas;
import videoclubjpa.views.PeliculasView;

/**
 *
 * @author alumno
 */
public class VideoclubJPA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame peliculasFrame = new JFrame();
        peliculasFrame.setContentPane(new PeliculasView());
        peliculasFrame.setBounds(100, 100, 640, 480);
        peliculasFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        peliculasFrame.setVisible(true);
    }
    
}
