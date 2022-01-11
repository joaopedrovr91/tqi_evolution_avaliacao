package com.projetofinaltqi.joaopedro.impl;

import com.projetofinaltqi.joaopedro.models.Emprestimo;
import com.projetofinaltqi.joaopedro.models.EmprestimoRegras;
import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

public class EmprestimoRegrasImpl implements EmprestimoRegras {


    @Override
    public boolean validaEmprestimo(@NotNull Emprestimo emprestimo) {
        /*
            O máximo de parcelas será 60
            e a data da primeira parcela deve ser no máximo 3 meses após o dia atual.
        */
        Calendar dataCadastro = Calendar.getInstance();
        dataCadastro.setTime(emprestimo.getDataPrimeiraParcela());
        Calendar hoje = Calendar.getInstance();

        //calcula diferença
        int meses = (hoje.get(Calendar.YEAR) * 12 + hoje.get(Calendar.MONTH))
                - (dataCadastro.get(Calendar.YEAR) * 12 + dataCadastro.get(Calendar.MONTH));

        if(meses > 3){
            return false;
        }

        if( emprestimo.getQuantidadeParcelas() > 60 ){
            return false;
        }

        return true;
    }
}
