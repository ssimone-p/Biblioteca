package org.Bibliotech.DAOimplementazione;

import org.Bibliotech.ConnessioneDB;
import org.Bibliotech.DAO.FiltriDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ImplementazioneFiltri implements FiltriDao {
    private Connection connection;

    public ImplementazioneFiltri() {
        try {
            connection= ConnessioneDB.getInstance().connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<String> getAutoriLibri() {
        ArrayList<String> autori = new ArrayList<>();
        String getAutoriQuery = "SELECT DISTINCT a.nome, a.cognome FROM (b.libro as l NATURAL JOIN b.autorelibro as al) JOIN b.autore as a on al.id_autore = a.id_autore ORDER BY cognome, nome";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(getAutoriQuery);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                autori.add(rs.getString("nome") + " " + rs.getString("cognome"));
            }
        } catch(SQLException e){

        }
        return autori;
    }

    @Override
    public ArrayList<String> getGeneriLibri() {
        ArrayList<String> generi = new ArrayList<>();
        String getGenereQuery = "SELECT DISTINCT FROM b.libro ORDER BY genere";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(getGenereQuery);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                generi.add(rs.getString("genere"));
            }
        } catch(SQLException e){

        }
        return generi;
    }

    @Override
    public ArrayList<String> getLingueLibri() {
        ArrayList<String> lingue = new ArrayList<>();
        String getLinguaQuery = "SELECT DISTINCT lingua FROM b.libro ORDER BY lingua";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(getLinguaQuery);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                lingue.add(rs.getString("lingua"));
            }
        } catch(SQLException e){

        }
        return lingue;
    }

    @Override
    public ArrayList<String> getEditoriLibri
            () {
        ArrayList<String> editori = new ArrayList<>();
        String getEditoreQuery = "SELECT DISTINCT editore FROM b.libro ORDER BY editore";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(getEditoreQuery);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                editori.add(rs.getString("editore"));
            }
        } catch(SQLException e){

        }
        return editori;
    }

    @Override
    public ArrayList<String> getFormatiLibri() {
        ArrayList<String> formati = new ArrayList<>();
        String getFormatoQuery = "SELECT DISTINCT formato FROM b.libro ORDER BY formato";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(getFormatoQuery);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                formati.add(rs.getString("formato"));
            }
        } catch(SQLException e){

        }
        return formati;
    }

    public ArrayList<String> getColumns(){
        ArrayList<String> columns = new ArrayList<>();
        String getColumnsQuery = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'view_libro_autore_prezzo'";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(getColumnsQuery);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                columns.add(rs.getString("COLUMN_NAME"));

    @Override
    public ArrayList<String> getAutoriArticoli() {
        ArrayList<String> autori = new ArrayList<>();
        String getAutoriQuery = "SELECT DISTINCT au.nome, au.cognome FROM (b.articolo as ar NATURAL JOIN b.autorearticolo as aa ) JOIN b.autore as au on aa.id_autore = au.id_autore ORDER BY cognome, nome";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(getAutoriQuery);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                autori.add(rs.getString("nome") + " " + rs.getString("cognome"));
            }
        } catch(SQLException e){

        }
        return columns;

        return autori;
    }

    @Override
    public ArrayList<String> getLinguaArticoli() {
        ArrayList<String> lingue = new ArrayList<>();
        String getLinguaQuery = "SELECT DISTINCT lingua FROM b.articolo ORDER BY lingua";
        return lingue;
    }

    @Override
    public ArrayList<String> getFormatoArticoli() {
        ArrayList<String> formati = new ArrayList<>();
        String getFormatoQuery = "SELECT DISTINCT formato FROM b.articolo ORDER BY formato";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getFormatoQuery);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                formati.add(rs.getString("formato"));
            }
        } catch (SQLException e) {
        }
        return formati;
    }

    @Override
    public ArrayList<String> getRivisteArticoli() {
        ArrayList<String> riviste = new ArrayList<>();
        String getRivistaQuery = "SELECT DISTINCT r.nome FROM (b.articoloinrivista AS ar NATURAL b.rivista AS r) ORDER BY r.nome";
        return riviste;
    }
}
} catch (SQLException e) {
            throw new RuntimeException(e);
        }