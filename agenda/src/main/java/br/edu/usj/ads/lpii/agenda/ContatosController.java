package br.edu.usj.ads.lpii.agenda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/contato")
public class ContatosController {

    @Autowired
    ContatoRepository contatoRepository;

    @GetMapping
    public ModelAndView listar() {
        List<Contato> lista = new ArrayList<>();
        contatoRepository.findAll().forEach(lista::add);

        ModelAndView modelAndView = new ModelAndView("listaContatos");
        modelAndView.addObject("contatos", lista);

        return modelAndView;
    }

    @PostMapping
    public String adiciona(@RequestParam String nome, @RequestParam String cidade)
    {
        Contato c = new Contato();
        c.setNome(nome);
        c.setCidade(cidade);

        contatoRepository.save(c);

        return "listaContatos";
    }

    @RequestMapping(path="/delete/{id}", method = RequestMethod.GET)
    public String apaga(@PathVariable Long id) {
        contatoRepository.deleteById(id);
        return "listaContatos";
    }

    @RequestMapping(path="/delete", method = RequestMethod.POST)
    public String apagaForm(@RequestParam Long id) {
        contatoRepository.deleteById(id);
        return "listaContatos";
    }

}
