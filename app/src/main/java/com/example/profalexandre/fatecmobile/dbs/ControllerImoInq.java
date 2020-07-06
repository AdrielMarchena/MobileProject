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

import com.example.profalexandre.fatecmobile.modelos.ImoInqBean;
import com.example.profalexandre.fatecmobile.modelos.ImovelBean;

import java.util.ArrayList;
import java.util.List;

public class ControllerImoInq {

    private static BancoHelper dbHelper = null;
    private static SQLiteDatabase db = null;

    public ControllerImoInq(Context context) {
        if (dbHelper == null ) {
            dbHelper = new BancoHelper(context);
        }
    }

    public String inserir(ImoInqBean imq) {
        db = dbHelper.getWritableDatabase();
        ContentValues valores;
        long resultado;
        String retorno;

        valores = new ContentValues();
        valores.put("ID_IMOVEL", imq.getIdImovel());
        valores.put("ID_INQUILINO", imq.getIdInquilino());
        valores.put("OBS", imq.getObs());
        resultado = db.insert(BancoHelper.TABELA_II, null, valores);
        db.close();

        return (resultado == -1) ? "Erro ao inserir registro" : "Registro inserido com sucesso";

    }

    public String excluir(ImoInqBean imq) {
        String retorno = "Resgistro Excluido com Sucesso";
        String where = "ID = " + imq.getId();
        db = dbHelper.getReadableDatabase();
        db.delete(BancoHelper.TABELA_II,where,null);
        db.close();
        return retorno;
    }

    public String alterar(ImoInqBean imq) {
        db = dbHelper.getWritableDatabase();
        ContentValues valores;
        String retorno = "Registro Alterado com sucesso";
        String where = "ID = " + imq.getId();
        valores = new ContentValues();
        valores.put("ID_IMOVEL", imq.getIdImovel());
        valores.put("ID_INQUILINO", imq.getIdInquilino());
        valores.put("OBS", imq.getObs());
        db.update(BancoHelper.TABELA_II, valores,where,null);
        db.close();
        return retorno;
    }

    public List<ImoInqBean> listarImoInq() {
        List<ImoInqBean> imoInqs = new ArrayList<ImoInqBean>();
        String selectQuery = "SELECT * FROM " + BancoHelper.TABELA_II ;
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                ImoInqBean imq = new ImoInqBean();
                imq.setId(""+cursor.getInt(0));
                imq.setIdImovel(cursor.getString(1));
                imq.setIdInquilino(cursor.getString(2));
                imq.setObs(cursor.getString(3));
                imoInqs.add(imq);
            } while (cursor.moveToNext());
        }
        return imoInqs;
    }

    public List<ImoInqBean> listarImoInq(ImoInqBean imqEnt) {
        List<ImoInqBean> imoInqs = new ArrayList<ImoInqBean>();
        String parametro = imqEnt.getObs();
        String selectQuery = "SELECT ID, ID_IMOVEL,ID_INQUILINO, OBS FROM " + BancoHelper.TABELA_II + " WHERE OBS LIKE ?" ;
        String[] whereArgs = new String[] { "%" + parametro + "%"  };
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, whereArgs);
        if (cursor.moveToFirst()) {
            do {
                ImoInqBean imq = new ImoInqBean();
                imq.setId(""+cursor.getInt(0));
                imq.setIdImovel(cursor.getString(1));
                imq.setIdInquilino(cursor.getString(2));
                imq.setObs(cursor.getString(3));
                imoInqs.add(imq);
            } while (cursor.moveToNext());
        }
        return imoInqs;
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
