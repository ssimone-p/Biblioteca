package org.Bibliotech.DAOimplementazione;

import org.Bibliotech.ConnessioneDB;
import org.Bibliotech.DAO.LibroDao;
import org.Bibliotech.Model.Libri;
import org.Bibliotech.Model.Libro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ImplementazioneLibro implements LibroDao {
    private Connection connection;
    public ImplementazioneLibro() {
        try {
            connection= ConnessioneDB.getInstance().connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public boolean addLibro(String titolo, String isbn, String autorinome_cognome, String dataPubblicazione, String editore, String genere, String lingua, String formato, double prezzo, String nome_serie_di_appartnenza, String issn_serie_di_appartenenza){
        String addLibroQuery= "INSERT INTO b.ins_libro_autore_serie (titolo, isbn, autorinome_cognome, datapubblicazione, editore, genere, lingua, formato, prezzo, nome_serie_di_appartnenza, issn_serie_di_appartenenza ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(addLibroQuery);
            preparedStatement.setString(1, titolo);
            preparedStatement.setString(2, isbn);
            preparedStatement.setString(3, autorinome_cognome);
            preparedStatement.setString(4, dataPubblicazione);
            preparedStatement.setString(5, editore);
            preparedStatement.setString(6, genere);
            preparedStatement.setString(7, lingua);
            preparedStatement.setString(8, formato);
            preparedStatement.setDouble(9, prezzo);
            preparedStatement.setString(10, nome_serie_di_appartnenza);
            preparedStatement.setString(11, issn_serie_di_appartenenza);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public Libri getLibri() {
        Libri libri = new Libri();
        String getLibriQuery = "SELECT * FROM b.libro";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getLibriQuery);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Libro libro = new Libro();
                libro.setTitolo(rs.getString("titolo"));
                libro.setGenere(rs.getString("genere"));
                libro.setEditore(rs.getString("editore"));
                libro.setDataPubblicazione(rs.getString("datapubblicazione"));
                libro.setIsbn(rs.getString("isbn"));
                libro.setFormato(rs.getString("formato"));
                libro.setLingua(rs.getString("lingua"));
                libro.setPrezzo(rs.getDouble("prezzo"));
                libri.addLibro(libro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return libri;
    }

    @Override
    public Libro getLibroByIsbn(String isbn) {
        Libro libro = new Libro();
        String getLibroByIsbnQuery = "SELECT * FROM b.libro WHERE isbn = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getLibroByIsbnQuery);
            preparedStatement.setString(1, isbn);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                libro.setTitolo(rs.getString("titolo"));
                libro.setGenere(rs.getString("genere"));
                libro.setEditore(rs.getString("editore"));
                libro.setDataPubblicazione(rs.getString("datapubblicazione"));
                libro.setIsbn(rs.getString("isbn"));
                libro.setFormato(rs.getString("formato"));
                libro.setLingua(rs.getString("lingua"));
                libro.setPrezzo(rs.getDouble("prezzo"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return libro;
    }

    @Override
    public Libri getLibriByTitolo(String titolo) {
        Libri libri = new Libri();
        String getLibriByTitoloQuery = "SELECT * FROM b.libro WHERE titolo = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getLibriByTitoloQuery);
            preparedStatement.setString(1, titolo);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Libro libro = new Libro();
                libro.setTitolo(rs.getString("titolo"));
                libro.setGenere(rs.getString("genere"));
                libro.setEditore(rs.getString("editore"));
                libro.setDataPubblicazione(rs.getString("datapubblicazione"));
                libro.setIsbn(rs.getString("isbn"));
                libro.setFormato(rs.getString("formato"));
                libro.setLingua(rs.getString("lingua"));
                libro.setPrezzo(rs.getDouble("prezzo"));
                libri.addLibro(libro);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return libri;
    }

    @Override
    public Libri getLibriByAutore(String autore) {
        Libri libri = new Libri();
        String getLibriByAutoreQuery = "SELECT l.titolo, l.isbn, l.datapubblicazione, l.editore, l.genere, l.lingua, l.formato, l.prezzo" +
                                       "FROM (b.libro as l NATURAL JOIN b.autorelibro as al) JOIN b.autore as a on al.id_autore = a.id_autore" +
                                       "WHERE a.nome = ? AND a.cognome = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getLibriByAutoreQuery);
            preparedStatement.setString(1, autore);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Libro libro = new Libro();
                libro.setTitolo(rs.getString("titolo"));
                libro.setGenere(rs.getString("genere"));
                libro.setEditore(rs.getString("editore"));
                libro.setDataPubblicazione(rs.getString("datapubblicazione"));
                libro.setIsbn(rs.getString("isbn"));
                libro.setFormato(rs.getString("formato"));
                libro.setLingua(rs.getString("lingua"));
                libro.setPrezzo(rs.getDouble("prezzo"));
                libri.addLibro(libro);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return libri;
    }

    @Override
    public Libri getLibriByLingua(String lingua) {
        Libri libri = new Libri();
        String getLibriByLinguaQuery = "SELECT * FROM b.libro WHERE lingua = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getLibriByLinguaQuery);
            preparedStatement.setString(1, lingua);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Libro libro = new Libro();
                libro.setTitolo(rs.getString("titolo"));
                libro.setGenere(rs.getString("genere"));
                libro.setEditore(rs.getString("editore"));
                libro.setDataPubblicazione(rs.getString("datapubblicazione"));
                libro.setIsbn(rs.getString("isbn"));
                libro.setFormato(rs.getString("formato"));
                libro.setLingua(rs.getString("lingua"));
                libro.setPrezzo(rs.getDouble("prezzo"));
                libri.addLibro(libro);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return libri;
    }


    @Override
    public Libri getLibriByEditore(String editore) {
        Libri libri = new Libri();
        String getLibriByEditoreQuery = "SELECT * FROM b.libro WHERE editore LIKE '%'?'%'";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getLibriByEditoreQuery);
            preparedStatement.setString(1, editore);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Libro libro = new Libro();
                libro.setTitolo(rs.getString("titolo"));
                libro.setGenere(rs.getString("genere"));
                libro.setEditore(rs.getString("editore"));
                libro.setDataPubblicazione(rs.getString("datapubblicazione"));
                libro.setIsbn(rs.getString("isbn"));
                libro.setFormato(rs.getString("formato"));
                libro.setLingua(rs.getString("lingua"));
                libro.setPrezzo(rs.getDouble("prezzo"));
                libri.addLibro(libro);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Libri getLibriByRangeDataPubblicazione(String dataPubblicazioneMin, String dataPubblicazioneMax) {
        Libri libri = new Libri();
        String getLibriByRangeDataPubblicazioneQuery = "SELECT * FROM b.libro WHERE datapubblicazione BETWEEN ? AND ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getLibriByRangeDataPubblicazioneQuery);
            preparedStatement.setString(1, dataPubblicazioneMin);
            preparedStatement.setString(2, dataPubblicazioneMax);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Libro libro = new Libro();
                libro.setTitolo(rs.getString("titolo"));
                libro.setGenere(rs.getString("genere"));
                libro.setEditore(rs.getString("editore"));
                libro.setDataPubblicazione(rs.getString("datapubblicazione"));
                libro.setIsbn(rs.getString("isbn"));
                libro.setFormato(rs.getString("formato"));
                libro.setLingua(rs.getString("lingua"));
                libro.setPrezzo(rs.getDouble("prezzo"));
                libri.addLibro(libro);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return libri;
    }

    @Override
    public Libri getLibriByDataPubblicazioneMin(String dataPubblicazioneMin) {
        Libri libri = new Libri();
        String getLibriByDataPubblicazioneMinQuery = "SELECT * FROM b.libro WHERE datapubblicazione >= ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getLibriByDataPubblicazioneMinQuery);
            preparedStatement.setString(1, dataPubblicazioneMin);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Libro libro = new Libro();
                libro.setTitolo(rs.getString("titolo"));
                libro.setGenere(rs.getString("genere"));
                libro.setEditore(rs.getString("editore"));
                libro.setDataPubblicazione(rs.getString("datapubblicazione"));
                libro.setIsbn(rs.getString("isbn"));
                libro.setFormato(rs.getString("formato"));
                libro.setLingua(rs.getString("lingua"));
                libro.setPrezzo(rs.getDouble("prezzo"));
                libri.addLibro(libro);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return libri;
    }

    @Override
    public Libri getLibriByDataPubblicazioneMax(String dataPubblicazioneMax) {
        Libri libri = new Libri();
        String getLibriByDataPubblicazioneMaxQuery = "SELECT * FROM b.libro WHERE datapubblicazione <= ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getLibriByDataPubblicazioneMaxQuery);
            preparedStatement.setString(1, dataPubblicazioneMax);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Libro libro = new Libro();
                libro.setTitolo(rs.getString("titolo"));
                libro.setGenere(rs.getString("genere"));
                libro.setEditore(rs.getString("editore"));
                libro.setDataPubblicazione(rs.getString("datapubblicazione"));
                libro.setIsbn(rs.getString("isbn"));
                libro.setFormato(rs.getString("formato"));
                libro.setLingua(rs.getString("lingua"));
                libro.setPrezzo(rs.getDouble("prezzo"));
                libri.addLibro(libro);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return libri;
    }

    @Override
    public Libri getLibriByFormato(String formato) {
        Libri libri = new Libri();
        String getLibriByFormatoQuery = "SELECT * FROM b.libro WHERE formato = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getLibriByFormatoQuery);
            preparedStatement.setString(1, formato);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Libro libro = new Libro();
                libro.setTitolo(rs.getString("titolo"));
                libro.setGenere(rs.getString("genere"));
                libro.setEditore(rs.getString("editore"));
                libro.setDataPubblicazione(rs.getString("datapubblicazione"));
                libro.setIsbn(rs.getString("isbn"));
                libro.setFormato(rs.getString("formato"));
                libro.setLingua(rs.getString("lingua"));
                libro.setPrezzo(rs.getDouble("prezzo"));
                libri.addLibro(libro);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return libri;
    }

    @Override
    public Libri getLibriByRangePrezzo(double min, double max) {
        Libri libri = new Libri();
        String getLibriByRangePrezzoQuery = "SELECT * FROM b.libro WHERE prezzo BETWEEN ? AND ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getLibriByRangePrezzoQuery);
            preparedStatement.setDouble(1, min);
            preparedStatement.setDouble(2, max);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Libro libro = new Libro();
                libro.setTitolo(rs.getString("titolo"));
                libro.setGenere(rs.getString("genere"));
                libro.setEditore(rs.getString("editore"));
                libro.setDataPubblicazione(rs.getString("datapubblicazione"));
                libro.setIsbn(rs.getString("isbn"));
                libro.setFormato(rs.getString("formato"));
                libro.setLingua(rs.getString("lingua"));
                libro.setPrezzo(rs.getDouble("prezzo"));
                libri.addLibro(libro);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return libri;
    }

    @Override
    public Libri getLibriByPrezzoMin(double prezzoMin) {
        Libri libri = new Libri();
        String getLibriByPrezzoMinQuery = "SELECT * FROM b.libro WHERE prezzo >= ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getLibriByPrezzoMinQuery);
            preparedStatement.setDouble(1, prezzoMin);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Libro libro = new Libro();
                libro.setTitolo(rs.getString("titolo"));
                libro.setGenere(rs.getString("genere"));
                libro.setEditore(rs.getString("editore"));
                libro.setDataPubblicazione(rs.getString("datapubblicazione"));
                libro.setIsbn(rs.getString("isbn"));
                libro.setFormato(rs.getString("formato"));
                libro.setLingua(rs.getString("lingua"));
                libro.setPrezzo(rs.getDouble("prezzo"));
                libri.addLibro(libro);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return libri;
    }

    @Override
    public Libri getLibriByPrezzoMax(double prezzoMax) {
        Libri libri = new Libri();
        String getLibriByPrezzoMaxQuery = "SELECT * FROM b.libro WHERE prezzo <= ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getLibriByPrezzoMaxQuery);
            preparedStatement.setDouble(1, prezzoMax);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Libro libro = new Libro();
                libro.setTitolo(rs.getString("titolo"));
                libro.setGenere(rs.getString("genere"));
                libro.setEditore(rs.getString("editore"));
                libro.setDataPubblicazione(rs.getString("datapubblicazione"));
                libro.setIsbn(rs.getString("isbn"));
                libro.setFormato(rs.getString("formato"));
                libro.setLingua(rs.getString("lingua"));
                libro.setPrezzo(rs.getDouble("prezzo"));
                libri.addLibro(libro);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return libri;
    }

    @Override
    public Libri getLibriByGenere(String genere) {
        Libri libri = new Libri();
        String getLibriByGenereQuery = "SELECT * FROM b.libro WHERE genere LIKE '%'?'%'";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getLibriByGenereQuery);
            preparedStatement.setString(1, genere);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Libro libro = new Libro();
                libro.setTitolo(rs.getString("titolo"));
                libro.setGenere(rs.getString("genere"));
                libro.setEditore(rs.getString("editore"));
                libro.setDataPubblicazione(rs.getString("datapubblicazione"));
                libro.setIsbn(rs.getString("isbn"));
                libro.setFormato(rs.getString("formato"));
                libro.setLingua(rs.getString("lingua"));
                libro.setPrezzo(rs.getDouble("prezzo"));
                libri.addLibro(libro);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return libri;
    }
}
