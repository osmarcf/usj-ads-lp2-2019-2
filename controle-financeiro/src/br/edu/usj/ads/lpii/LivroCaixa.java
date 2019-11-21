package br.edu.usj.ads.lpii;

import java.util.ArrayList;
import java.util.List;

public class LivroCaixa {

    List<Registro> registros = new ArrayList<>();

    public void adicionaRegistro(Registro r) {
        registros.add(r);
    }

    public List<Registro> getRegistros() {
        return registros;
    }
}
