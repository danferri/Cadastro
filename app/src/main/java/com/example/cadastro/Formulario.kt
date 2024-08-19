package com.example.cadastro

data class Formulario(
    val nomeCompleto: String,
    val telefone: String,
    val email: String,
    val ingressarListaEmail: Boolean,
    val sexo: String,
    val cidade: String,
    val uf: String
) {
    override fun toString(): String {
        return "Nome: $nomeCompleto\nTelefone: $telefone\nEmail: $email\n" +
                "Ingressar na lista de emails: $ingressarListaEmail\n" +
                "Sexo: $sexo\nCidade: $cidade\nUF: $uf"
    }
}