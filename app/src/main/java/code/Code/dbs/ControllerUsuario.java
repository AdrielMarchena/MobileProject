package code.Code.dbs;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import code.Code.modelos.UsuarioBean;

import java.util.ArrayList;
import java.util.List;

public class ControllerUsuario {

    private static BancoHelper dbHelper = null;
    private static SQLiteDatabase db = null;

    public ControllerUsuario(Context context) {
        if (dbHelper == null ) {
            dbHelper = new BancoHelper(context);
        }
    }

    public String inserir(UsuarioBean usu) {
        db = dbHelper.getWritableDatabase();
        ContentValues valores;
        long resultado;
        String retorno;
        valores = new ContentValues();
        valores.put("LOGIN", usu.getLogin());
        valores.put("SENHA", usu.getSenha());
        valores.put("STATUS", usu.getStatus());
        valores.put("TIPO", usu.getTipo());
        resultado = db.insert(BancoHelper.TABELA_U, null, valores);
        db.close();

        if (resultado == -1) {
            retorno = "Erro ao inserir registro";
        } else {
            retorno = "Registro Inserido com sucesso";
        }
        return retorno;
    }

    public String excluir(UsuarioBean usu) {
        String retorno = "Resgistro Excluir com Sucesso";
        String where = "ID = " + usu.getId();
        db = dbHelper.getReadableDatabase();
        db.delete(BancoHelper.TABELA_U,where,null);
        db.close();
        return retorno;
    }

    public String alterar(UsuarioBean usu) {
        db = dbHelper.getWritableDatabase();
        ContentValues valores;
        String retorno = "Registro Alterado com sucesso";
        String where = "ID = " + usu.getId();
        valores = new ContentValues();
        valores.put("LOGIN", usu.getLogin());
        valores.put("SENHA", usu.getSenha());
        valores.put("STATUS", usu.getStatus());
        valores.put("TIPO", usu.getTipo());
        db.update(BancoHelper.TABELA_U, valores,where,null);
        db.close();
        return retorno;
    }

    public List<UsuarioBean> listarUsuarios() {
        List<UsuarioBean> usuarios = new ArrayList<UsuarioBean>();
        String selectQuery = "SELECT * FROM USUARIOS" ;
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                UsuarioBean usu = new UsuarioBean();
                usu.setId(""+cursor.getInt(0));
                usu.setLogin(cursor.getString(1));
                usu.setSenha(cursor.getString(2));
                usu.setStatus(cursor.getString(3));
                usu.setTipo(cursor.getString(4));
                usuarios.add(usu);
            } while (cursor.moveToNext());
        }
        return usuarios;
    }

    public List<UsuarioBean> listarUsuarios(UsuarioBean usuEnt) {
        List<UsuarioBean> usuarios = new ArrayList<UsuarioBean>();
        String parametro = usuEnt.getLogin();
        String selectQuery = "SELECT ID, LOGIN, SENHA, STATUS, TIPO FROM USUARIOS WHERE LOGIN LIKE ?" ;
        String[] whereArgs = new String[] { "%" + parametro + "%"  };
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, whereArgs);
        if (cursor.moveToFirst()) {
            do {
                UsuarioBean usu = new UsuarioBean();
                usu.setId(""+cursor.getInt(0));
                usu.setLogin(cursor.getString(1));
                usu.setSenha(cursor.getString(2));
                usu.setStatus(cursor.getString(3));
                usu.setTipo(cursor.getString(4));
                usuarios.add(usu);
            } while (cursor.moveToNext());
        }
        return usuarios;
    }

    public UsuarioBean validarUsuarios(UsuarioBean usuEnt) {
        UsuarioBean usu = new UsuarioBean();
        String loginPar = '"' + usuEnt.getLogin().trim() + '"';
        String senhaPar = '"' + usuEnt.getSenha().trim() + '"';
        String selectQuery = "SELECT ID, LOGIN, SENHA, STATUS, TIPO FROM USUARIOS WHERE LOGIN = ? AND SENHA = ? " ;
        String[] whereArgs = new String [] {loginPar,senhaPar};
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, whereArgs);
        if (cursor.moveToFirst()) {
            do {
                usu.setId(""+cursor.getInt(0));
                usu.setLogin(cursor.getString(1));
                usu.setSenha(cursor.getString(2));
                usu.setStatus(cursor.getString(3));
                usu.setTipo(cursor.getString(4));
            } while (cursor.moveToNext());
        }
        return usu;
    }
}
