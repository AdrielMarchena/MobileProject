package com.example.profalexandre.fatecmobile.dbs;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.profalexandre.fatecmobile.modelos.ImovelBean;
import com.example.profalexandre.fatecmobile.modelos.InquilinoBean;

import java.util.ArrayList;
import java.util.List;

public class ControllerInquilino {

    private static BancoHelper dbHelper = null;
    private static SQLiteDatabase db = null;

    public ControllerInquilino(Context context) {
        if (dbHelper == null ) {
            dbHelper = new BancoHelper(context);
        }
    }

    public String inserir(InquilinoBean inq) {
        db = dbHelper.getWritableDatabase();
        ContentValues valores;
        long resultado;
        String retorno;

        valores = new ContentValues();
        valores.put("NOME", inq.getNome());
        resultado = db.insert(BancoHelper.TABELA_IQ, null, valores);
        db.close();

        return (resultado == -1) ? "Erro ao inserir registro" : "Registro inserido com sucesso";

    }

    public String excluir(InquilinoBean inq) {
        String retorno = "Resgistro Excluido com Sucesso";
        String where = "ID = " + inq.getId();
        db = dbHelper.getReadableDatabase();
        db.delete(BancoHelper.TABELA_IQ,where,null);
        db.close();
        return retorno;
    }

    public String alterar(InquilinoBean inq) {
        db = dbHelper.getWritableDatabase();
        ContentValues valores;
        String retorno = "Registro Alterado com sucesso";
        String where = "ID = " + inq.getId();
        valores = new ContentValues();
        valores.put("NOME", inq.getNome());
        db.update(BancoHelper.TABELA_IQ, valores,where,null);
        db.close();
        return retorno;
    }

    public List<InquilinoBean> listarInquilinos() {
        List<InquilinoBean> inquilinos = new ArrayList<InquilinoBean>();
        String selectQuery = "SELECT * FROM " + BancoHelper.TABELA_IQ ;
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                InquilinoBean inq = new InquilinoBean();
                inq.setId(""+cursor.getInt(0));
                inq.setNome(cursor.getString(1));
                inquilinos.add(inq);
            } while (cursor.moveToNext());
        }
        return inquilinos;
    }

    public List<InquilinoBean> listarInquilinos(InquilinoBean inqEnt) {
        List<InquilinoBean> inquilinos = new ArrayList<InquilinoBean>();
        String parametro = inqEnt.getNome();
        String selectQuery = "SELECT ID,NOME FROM " + BancoHelper.TABELA_IQ + " WHERE NOME LIKE ?" ;
        String[] whereArgs = new String[] { "%" + parametro + "%"  };
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, whereArgs);
        if (cursor.moveToFirst()) {
            do {
                InquilinoBean inq = new InquilinoBean();
                inq.setId(""+cursor.getInt(0));
                inq.setNome(cursor.getString(1));
                inquilinos.add(inq);
            } while (cursor.moveToNext());
        }
        return inquilinos;
    }
/*
    public ImovelBean validarImoveis(ImovelBean imoEnt) {
        ImovelBean imo = new ImovelBean();
        String loginPar = '"' + imoEnt.getLogin().trim() + '"';
        String senhaPar = '"' + imoEnt.getSenha().trim() + '"';
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
    }*/

}
