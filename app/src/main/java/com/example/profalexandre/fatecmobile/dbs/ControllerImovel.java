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
import com.example.profalexandre.fatecmobile.modelos.UsuarioBean;

import java.util.ArrayList;
import java.util.List;

public class ControllerImovel {

    private static BancoHelper dbHelper = null;
    private static SQLiteDatabase db = null;

    public ControllerImovel(Context context) {
        if (dbHelper == null ) {
            dbHelper = new BancoHelper(context);
        }
    }

    public String inserir(ImovelBean imo) {
        db = dbHelper.getWritableDatabase();
        ContentValues valores;
        long resultado;
        String retorno;

        valores = new ContentValues();
        valores.put("ENDERECO", imo.getEndereco());
        valores.put("PROPRIETARIO", imo.getProprietario());
        valores.put("VALOR_ALUGUEL", imo.getValorAluguel());
        resultado = db.insert(BancoHelper.TABELA_IM, null, valores);
        db.close();

        return (resultado == -1) ? "Erro ao inserir registro" : "Registro inserido com sucesso";

    }

    public String excluir(ImovelBean imo) {
        String retorno = "Resgistro Excluido com Sucesso";
        String where = "ID = " + imo.getId();
        db = dbHelper.getReadableDatabase();
        db.delete(BancoHelper.TABELA_IM,where,null);
        db.close();
        return retorno;
    }

    public String alterar(ImovelBean imo) {
        db = dbHelper.getWritableDatabase();
        ContentValues valores;
        String retorno = "Registro Alterado com sucesso";
        String where = "ID = " + imo.getId();
        valores = new ContentValues();
        valores.put("ENDERECO", imo.getEndereco());
        valores.put("PROPRIETARIO", imo.getProprietario());
        valores.put("VALOR_ALUGUEL", imo.getValorAluguel());
        db.update(BancoHelper.TABELA_IM, valores,where,null);
        db.close();
        return retorno;
    }

    public List<ImovelBean> listarImoveis() {
        List<ImovelBean> imoveis = new ArrayList<ImovelBean>();
        String selectQuery = "SELECT * FROM " + BancoHelper.TABELA_IM ;
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                ImovelBean imo = new ImovelBean();
                imo.setId(""+cursor.getInt(0));
                imo.setEndereco(cursor.getString(1));
                imo.setProprietario(cursor.getString(2));
                imo.setValorAluguel(cursor.getDouble(3));
                imoveis.add(imo);
            } while (cursor.moveToNext());
        }
        return imoveis;
    }

    public List<ImovelBean> listarImoveis(ImovelBean imoEnt) {
        List<ImovelBean> imoveis = new ArrayList<ImovelBean>();
        String parametro = imoEnt.getProprietario();
        String selectQuery = "SELECT ID, ENDERECO, PROPRIETARIO, VALOR_ALUGUEL FROM " + BancoHelper.TABELA_IM + " WHERE PROPRIETARIO LIKE ?" ;
        String[] whereArgs = new String[] { "%" + parametro + "%"  };
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, whereArgs);
        if (cursor.moveToFirst()) {
            do {
                ImovelBean imo = new ImovelBean();
                imo.setId(""+cursor.getInt(0));
                imo.setEndereco(cursor.getString(1));
                imo.setProprietario(cursor.getString(2));
                imo.setValorAluguel(cursor.getDouble(3));
                imoveis.add(imo);
            } while (cursor.moveToNext());
        }
        return imoveis;
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
