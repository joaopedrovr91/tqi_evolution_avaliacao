package com.projetofinaltqi.joaopedro.controllers;

import com.projetofinaltqi.joaopedro.models.*;
import com.projetofinaltqi.joaopedro.repositories.ClienteRepository;
import com.projetofinaltqi.joaopedro.repositories.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    private EmprestimoRegras emprestimoRegras;

    @GetMapping("/cadastro")
    public String form(){
        return "cliente/formCliente";
    }

    @PostMapping("/cadastro")
    public String form(Cliente cliente){

        clienteRepository.save(cliente);

        return "redirect:/cadastro";
    }

    /*@GetMapping("/login")
    public String login(Cliente cliente){

        try{
            clienteRepository.verificaLogin(cliente);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }*/

    @GetMapping("/solicitar")
    public String empForm(){

        return "cliente/formEmprestimo";
    }

    @PostMapping("/solicitar")
    public String empForm(Emprestimo emprestimo) throws ParseException {

        //O máximo de parcelas será 60
        // e a data da primeira parcela deve ser no máximo 3 meses após o dia atual.

        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(emprestimo.getPrimeiraParcela());
        emprestimo.setDataPrimeiraParcela(date);
        if(emprestimoRegras.validaEmprestimo(emprestimo)) {
            emprestimoRepository.save(emprestimo);
        }
        else{
            return "dados invalidos";
        }
        return "redirect:/solicitar";

    }
    /*O cliente pode visualizar a lista de empréstimos solicitados por ele mesmo e também os detalhes de um de seus empréstimos.
    Na listagem, devemos retornar no mínimo o código do empréstimo, o valor e a quantidade de parcelas.
    No detalhe do empréstimo, devemos retornar: código do empréstimo, valor, quantidade de parcelas, data da primeira parcela,
    e-mail do cliente e renda do cliente.*/

    @GetMapping("/listar")
    public List<EmprestimoDTO> lista(String cpf){

        List<Emprestimo> emprestimoList = new ArrayList<>();
        List<EmprestimoDTO> emprestimoList2 = new ArrayList<>();
        emprestimoList = emprestimoRepository.findByCpf(cpf);
        for(Emprestimo obj : emprestimoList ){
            EmprestimoDTO emprestimoDTO = new EmprestimoDTO(obj);
            emprestimoList2.add(emprestimoDTO);
        }

        return emprestimoList2;

    }

    @GetMapping("/listar-detalhes")
    public List<EmprestimoDetDTO> listaDetalhes(String cpf){
        List<Emprestimo> emprestimoList = new ArrayList<>();
        List<EmprestimoDetDTO> emprestimoList2 = new ArrayList<>();
        emprestimoList = emprestimoRepository.findByCpf(cpf);
        Cliente c = clienteRepository.findByCpf(cpf);
        for(Emprestimo obj : emprestimoList ){
            EmprestimoDetDTO emprestimoDetDTO = new EmprestimoDetDTO(obj,c);
            emprestimoList2.add(emprestimoDetDTO);
        }
        return emprestimoList2;
    }











}
