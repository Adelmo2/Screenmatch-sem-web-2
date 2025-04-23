package br.com.alura.screenmach.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface iConverteDados {
    <T> T obterDados(String json, Class<T> classe) throws JsonProcessingException;
}
