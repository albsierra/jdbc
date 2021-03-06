/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iesdosmares.videoclubmongo;


import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author jose
 */
public class Peliculas extends javax.swing.JFrame {
    
    private final MongoClient conexion;
    private MongoCollection<Document> peliculasCollection;
    private List<Document> rs;
    private int index;
    
    private void cargarPeliculas() {
        try {
            MongoDatabase videoclubDB = conexion.getDatabase("videoclub");
            peliculasCollection = videoclubDB.getCollection("peliculas");
            rs = peliculasCollection.find().into(new ArrayList<>());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }

    private void cargaCamposPelicula() {
        Document doc = rs.get(index);
        try {
            jTextID.setText(doc.get("id").toString());
            jTextTitulo.setText(doc.getString("titulo"));
            jTextGenero.setText(doc.getString("genero"));
            jTextDuracion.setText(doc.get("duracion").toString());
            jTextDirector.setText(doc.getString("director"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    /**
     * Creates new form Peliculas
     * @param conexion La conexión que se utilizará para el acceso a la B.D.
     */
    public Peliculas(MongoClient conexion) {
        this.conexion = conexion;
        cargarPeliculas();
        initComponents();
        if (!rs.isEmpty()) {
            //Mostrar la informacion de la 1ª peli
            cargaCamposPelicula();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelID = new javax.swing.JLabel();
        jTextID = new javax.swing.JTextField();
        jLabelTitulo = new javax.swing.JLabel();
        jTextTitulo = new javax.swing.JTextField();
        jLabelGenero = new javax.swing.JLabel();
        jTextGenero = new javax.swing.JTextField();
        jLabelDuracion = new javax.swing.JLabel();
        jTextDuracion = new javax.swing.JTextField();
        jLabelDirector = new javax.swing.JLabel();
        jTextDirector = new javax.swing.JTextField();
        jButtonSiguiente = new javax.swing.JButton();
        jButtonAnterior = new javax.swing.JButton();
        jButtonGrabar = new javax.swing.JButton();
        jButtonAnadir = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();

        setTitle("Películas");

        jLabelID.setText("ID:");

        jLabelTitulo.setText("Título:");

        jLabelGenero.setText("Género:");

        jLabelDuracion.setText("Duración:");

        jLabelDirector.setText("Director:");

        jButtonSiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iesdosmares/videoclubmongo/images/siguiente.png"))); // NOI18N
        jButtonSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSiguienteActionPerformed(evt);
            }
        });

        jButtonAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iesdosmares/videoclubmongo/images/anterior.png"))); // NOI18N
        jButtonAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnteriorActionPerformed(evt);
            }
        });

        jButtonGrabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iesdosmares/videoclubmongo/images/grabar.png"))); // NOI18N
        jButtonGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGrabarActionPerformed(evt);
            }
        });

        jButtonAnadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iesdosmares/videoclubmongo/images/anadir.png"))); // NOI18N
        jButtonAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnadirActionPerformed(evt);
            }
        });

        jButtonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iesdosmares/videoclubmongo/images/eliminar.png"))); // NOI18N
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(38, Short.MAX_VALUE)
                        .addComponent(jButtonAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAnadir, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelID, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelTitulo, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelGenero, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelDuracion, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelDirector, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jTextID, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addComponent(jTextTitulo)
                                .addComponent(jTextGenero)
                                .addComponent(jTextDirector))
                            .addComponent(jTextDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelID)
                    .addComponent(jTextID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTitulo)
                    .addComponent(jTextTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelGenero)
                    .addComponent(jTextGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDuracion)
                    .addComponent(jTextDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDirector)
                    .addComponent(jTextDirector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButtonAnterior)
                        .addComponent(jButtonGrabar, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButtonAnadir)
                        .addComponent(jButtonSiguiente))
                    .addComponent(jButtonEliminar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnteriorActionPerformed
        if (index > 0) {
            index--;
            cargaCamposPelicula();
        }
    }//GEN-LAST:event_jButtonAnteriorActionPerformed

    private void jButtonSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSiguienteActionPerformed
        if (rs.size() > index + 1) {
            index++;
            cargaCamposPelicula();
        }
    }//GEN-LAST:event_jButtonSiguienteActionPerformed

    private void jButtonGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGrabarActionPerformed
        
        Document doc = rs.get(index);
        try {
            doc.put("id", jTextID.getText());
            doc.put("titulo", jTextTitulo.getText());
            doc.put("genero", jTextGenero.getText());
            doc.put("duracion", Integer.parseInt(jTextDuracion.getText()));
            doc.put("director", jTextDirector.getText());

            // Si previamente se le había asignado un ID es que ya existía
            // por lo que se está intentando modificar
            if (doc.get("_id") != null && !doc.get("_id").toString().isEmpty()) {
                actualiza(doc);
            } else {
                inserta(doc);
                cargaCamposPelicula();
                visibilizarBotonera(true);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButtonGrabarActionPerformed

    private void jButtonAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnadirActionPerformed
        Document doc = new Document();
        doc.append("id", "");
        doc.append("titulo", "");
        doc.append("genero", "");
        doc.append("duracion", "");
        doc.append("director", "");
        rs.add(doc);
        index = rs.size() - 1;
        cargaCamposPelicula();
        visibilizarBotonera(false);
    }//GEN-LAST:event_jButtonAnadirActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        // delete one document
        
        Document doc = rs.get(index);
        Bson filter = eq("_id", doc.get("_id"));
        DeleteResult result = peliculasCollection.deleteOne(filter);
        index = index > 0 ? index - 1 : index + 1; // fallaría en el caso de rs vacío
        actualizarRS();
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnadir;
    private javax.swing.JButton jButtonAnterior;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonGrabar;
    private javax.swing.JButton jButtonSiguiente;
    private javax.swing.JLabel jLabelDirector;
    private javax.swing.JLabel jLabelDuracion;
    private javax.swing.JLabel jLabelGenero;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JTextField jTextDirector;
    private javax.swing.JTextField jTextDuracion;
    private javax.swing.JTextField jTextGenero;
    private javax.swing.JTextField jTextID;
    private javax.swing.JTextField jTextTitulo;
    // End of variables declaration//GEN-END:variables

    private void visibilizarBotonera(boolean b) {
        jButtonAnterior.setVisible(b);
        jButtonSiguiente.setVisible(b);
        jButtonAnadir.setVisible(b);
        jButtonEliminar.setVisible(b);
    }

    private void actualiza(Document doc) {
        Bson filter = eq("_id", doc.get("_id"));// Define the update query:
        BasicDBObject updateQuery = new BasicDBObject();
        updateQuery.append("id", doc.get("id"));
        updateQuery.append("titulo", doc.get("titulo"));
        updateQuery.append("genero", doc.get("genero"));
        updateQuery.append("duracion", doc.get("duracion"));
        updateQuery.append("director", doc.get("director"));
        BasicDBObject setQuery = new BasicDBObject();
        setQuery.append("$set", updateQuery);

        peliculasCollection.updateOne(filter, setQuery);
        actualizarRS();
    }

    private void inserta(Document doc) {
        peliculasCollection.insertOne(doc);
        actualizarRS();
    }

    private void actualizarRS() {
        cargarPeliculas();
        cargaCamposPelicula();
    }
}
